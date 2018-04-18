package com.apporio.ubereats.mvp.ui.fragments.settings;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.data.network.model.LogoutResponse;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/18/2018.
 */

public class SettingsPresenter <V extends SettingsMvpView> extends BasePresenter<V>
        implements SettingMvpPresenter<V> {

    @Inject
    public SettingsPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onOptionLogoutClick() {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager().doLogoutApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LogoutResponse>() {
                    @Override
                    public void accept(LogoutResponse response) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getDataManager().setUserAsLoggedOut();
                        getMvpView().hideLoading();
                        getMvpView().openLoginActivity();
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
