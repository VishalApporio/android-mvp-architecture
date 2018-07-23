package com.tukin.user.mvp.ui.activity.viewCart;

import android.annotation.SuppressLint;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.db.model.CheckOutResponse;
import com.tukin.user.mvp.data.db.model.ViewCartResponse;
import com.tukin.user.mvp.location.LocationSession;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 5/5/2018.
 */

public class ViewCartPresenter<V extends ViewCartMvpView> extends BasePresenter<V>
        implements ViewCartMvpPresenter<V> {

    @Inject
    LocationSession locationSession;

    @Inject
    public ViewCartPresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void callAPiForViewCart() {

        getMvpView().showLoading();

        String user_id = getDataManager().getCurrentUserId().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("language_code", "" + "en");

        getCompositeDisposable().add(getDataManager()
                .doCallApiForViewCart(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ViewCartResponse>() {
                    @Override
                    public void accept(ViewCartResponse viewCartResponse) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().viewCartDetails(viewCartResponse, locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT));


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
    public void callApiForPlaceOrder() {

        getMvpView().showLoading();

        String user_id = getDataManager().getCurrentUserId().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("delivery_address", "" + locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT));
        data.put("drop_lat", "" + locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT));
        data.put("drop_long", "" + locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG));
        data.put("language_code", "" + "en");


        getCompositeDisposable().add(getDataManager()
                .doCallApiForPlaceOrder(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<CheckOutResponse>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void accept(CheckOutResponse placOrderResponse) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getDataManager().clearDatabase()
                                .subscribeOn(getSchedulerProvider().io())
                                .observeOn(getSchedulerProvider().ui())
                                .subscribe(new Consumer<Boolean>() {
                                    @Override
                                    public void accept(Boolean aBoolean) throws Exception {

                                        //  getMvpView().showMessage("Database cleared");

                                        getMvpView().hideLoading();

                                        getMvpView().finishViewCartActivity();

                                    }
                                });

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
}
