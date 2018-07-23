package com.tukin.user.mvp.ui.fragments.homefragment;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.onesignal.OneSignal;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.UpdateDeviceIdResponse;
import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/11/2018.
 */

public class HomeFragmentPresenter<V extends HomeFragmentMvpView> extends BasePresenter<V>
        implements HomeFragmentMvpPresenter<V> {


    String device_id;

    @Inject
    public HomeFragmentPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    @Override
    public void onViewAllRestuaranents() {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doViewResturanentsApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ViewResturanentsModel>() {
                    @Override
                    public void accept(ViewResturanentsModel response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        getMvpView().updateAllRestauranentsView(response);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        updatePlayerid();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));


    }

    @Override
    public void updatePlayerid() {

        final String user_id = getDataManager().getCurrentUserId().toString();

        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            @Override
            public void idsAvailable(String userId, String registrationId) {
                device_id = userId;
                Log.e("Device_id", "" + userId);

                HashMap<String, String> data = new HashMap<>();
                data.put("device_id", "" + device_id);
                data.put("flag", "" + "");
                data.put("user_id", "" + user_id);

                getCompositeDisposable().add(getDataManager()
                        .doUpdateDeviceId(data)
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<UpdateDeviceIdResponse>() {
                            @Override
                            public void accept(UpdateDeviceIdResponse response) throws Exception {

                                if (!isViewAttached()) {
                                    return;
                                }


                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                if (!isViewAttached()) {
                                    return;
                                }


                                // handle the login error here
                                if (throwable instanceof ANError) {
                                    ANError anError = (ANError) throwable;
                                    handleApiError(anError);
                                }
                            }
                        }));

            }
        });
    }
}
