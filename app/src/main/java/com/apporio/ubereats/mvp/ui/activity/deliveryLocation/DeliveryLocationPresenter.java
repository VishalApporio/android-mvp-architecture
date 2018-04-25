package com.apporio.ubereats.mvp.ui.activity.deliveryLocation;

import android.location.Location;
import android.location.LocationManager;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.data.network.model.GetLocationsModelClass;
import com.apporio.ubereats.mvp.di.others.PlacePredictions;
import com.apporio.ubereats.mvp.di.others.events.LocationSessionEvent;
import com.apporio.ubereats.mvp.location.LocationSession;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/19/2018.
 */

public class DeliveryLocationPresenter<V extends DeliveryLocationMvpView> extends BasePresenter<V>
        implements DeliveryLocationMvpPresenter<V> {

    @Inject
    LocationSession locationSession;

    @Inject
    public DeliveryLocationPresenter(DataManager dataManager,
                                     SchedulerProvider schedulerProvider,
                                     CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewAutoCompleteAddress(String value, Double latitude, Double longitude, String google_key) {


        //getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doAutoCompleteApiCall(value, latitude, longitude, google_key)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PlacePredictions>() {
                    @Override
                    public void accept(PlacePredictions response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        // getMvpView().hideLoading();
                        getMvpView().onViewAfterCallingAPi();

                        if (response.getPlaces().isEmpty()) {
                            getMvpView().onViewAfterListIsEmty();
                        } else {
                            getMvpView().onViewAfterListisNotEmpty();
                            getMvpView().getPlaces(response.getPlaces());
                        }


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        //  getMvpView().hideLoading();
                        getMvpView().onViewErrorOcurred();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }

    @Override
    public void getAddressFromApi(String place_id, String google_api_key) {

        getCompositeDisposable().add(getDataManager()
                .doGetLocationApiCall(place_id, google_api_key)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GetLocationsModelClass>() {
                    @Override
                    public void accept(GetLocationsModelClass response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        EventBus.getDefault().post(new LocationSessionEvent(
                                response.getResult().getGeometry().getLocation().getLat(),
                                +response.getResult().getGeometry().getLocation().getLng(),
                                ""+response.getResult().getName().toLowerCase().trim()));

                        getMvpView().getSelectedLocation(response);


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        //  getMvpView().hideLoading();
                        getMvpView().onViewErrorOcurred();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }

}
