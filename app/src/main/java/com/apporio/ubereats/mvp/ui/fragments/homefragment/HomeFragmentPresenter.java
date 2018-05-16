package com.apporio.ubereats.mvp.ui.fragments.homefragment;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/11/2018.
 */

public class HomeFragmentPresenter<V extends HomeFragmentMvpView> extends BasePresenter<V>
        implements HomeFragmentMvpPresenter<V> {

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

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));


    }
}
