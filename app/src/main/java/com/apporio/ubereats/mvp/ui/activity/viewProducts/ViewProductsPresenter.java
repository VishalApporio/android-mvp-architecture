package com.apporio.ubereats.mvp.ui.activity.viewProducts;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.mvp.data.DataManager;

import com.apporio.ubereats.mvp.data.network.model.allProductresponse.AllProductResponse;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/24/2018.
 */

public class ViewProductsPresenter<V extends ViewProductsMvpView> extends BasePresenter<V>
        implements ViewProductsMvpPresenter<V> {

    @Inject
    public ViewProductsPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    @Override
    public void callApiForViewAllProducts() {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doViewAllProductsApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<AllProductResponse>() {
                    @Override
                    public void accept(AllProductResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().viewAllRestauranentProducts(response);

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
