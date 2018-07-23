package com.tukin.user.mvp.ui.fragments.orders.mainOrder;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.db.model.orderHistory.OrderHistoryResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 5/7/2018.
 */

public class MainOrderPresenter<V extends MainOrderMvpView> extends BasePresenter<V>
        implements MainOrderMvpPresenter<V> {

    @Inject
    public MainOrderPresenter(DataManager dataManager,
                              SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);

    }

    @Override
    public void viewAllOrderResponse() {

        getMvpView().showLoading();

        String user_id = getDataManager().getCurrentUserId().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("language_code", "" + "1");

        getCompositeDisposable().add(getDataManager()
                .doViewAllOrderHistory(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<OrderHistoryResponse>() {
                    @Override
                    public void accept(OrderHistoryResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        getMvpView().viewAllHistoryResponse(response);

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
