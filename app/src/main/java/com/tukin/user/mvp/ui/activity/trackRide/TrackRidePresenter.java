package com.tukin.user.mvp.ui.activity.trackRide;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.GetDriverlocationResponse;
import com.tukin.user.mvp.data.network.model.trackRideDriverDetails.ViewDriverDetailsResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 5/16/2018.
 */

public class TrackRidePresenter<V extends TrackRideMvpView> extends BasePresenter<V>
        implements TrackRideMvpPresenter<V> {

    @Inject
    public TrackRidePresenter(DataManager dataManager,
                              SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void viewDriverDetailsApi(String order_id) {

        getMvpView().showLoading();

        Log.e("Order_id_presenter", "" + order_id);

        HashMap<String, String> data = new HashMap<>();
        data.put("order_id", "" + order_id);
        data.put("language_code", "" + "en");

        getCompositeDisposable().add(getDataManager()
                .doViewAllDriverDetails(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ViewDriverDetailsResponse>() {
                    @Override
                    public void accept(ViewDriverDetailsResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }


                        getMvpView().hideLoading();
                        getMvpView().getAllDriverDetailsResponse(response);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void getCurrentDriverLocation(String driver_id) {

       // getMvpView().showLoading();

        Log.e("driver_id", "" + driver_id);

        HashMap<String, String> data = new HashMap<>();
        data.put("driver_id", "" + driver_id);
        data.put("language_code", "" + "en");

        getCompositeDisposable().add(getDataManager()
                .doGetDriverCurrentLocation(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GetDriverlocationResponse>() {
                    @Override
                    public void accept(GetDriverlocationResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        getMvpView().getDriverCurrentLocation(response);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                     //   getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }
}
