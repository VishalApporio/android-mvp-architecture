package com.tukin.user.mvp.ui.activity.viewProducts;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.productResponse.ViewProductResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

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
    public void callApiForViewAllProducts(String category_id) {

        getMvpView().showLoading();

        Log.e("Category_id",""+ category_id);
        HashMap<String, String> data = new HashMap<>();
        data.put("category_id", "" + category_id);
        data.put("language_code", "" + "en");

        getCompositeDisposable().add(getDataManager()
                .doViewAllProductsApiCall(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ViewProductResponse>() {
                    @Override
                    public void accept(ViewProductResponse response) throws Exception {

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
