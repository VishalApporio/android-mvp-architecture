package com.tukin.user.mvp.ui.fragments.settings;

import com.androidnetworking.error.ANError;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.LoginRequest;
import com.tukin.user.mvp.data.network.model.LoginResponse;
import com.tukin.user.mvp.data.network.model.LogoutResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/18/2018.
 */

public class SettingsPresenter<V extends SettingsMvpView> extends BasePresenter<V>
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

        String user_id = getDataManager().getCurrentUserId().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("language_code", "" + "1");

        getCompositeDisposable().add(getDataManager()
                .doLogoutApiCall(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {

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

//        getCompositeDisposable().add(getDataManager().doLogoutApiCall(data)
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<LogoutResponse>() {
//                    @Override
//                    public void accept(LogoutResponse response) throws Exception {
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getDataManager().setUserAsLoggedOut();
//                        getMvpView().hideLoading();
//                        getMvpView().openLoginActivity();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the login error here
//                        if (throwable instanceof ANError) {
//                            ANError anError = (ANError) throwable;
//                            handleApiError(anError);
//                        }
//                    }
//                }));
    }

    @Override
    public void getUserInformation() {

        getMvpView().updateUserInformation(getDataManager().getCurrentUserProfilePicUrl(),getDataManager().getCurrentUserName());
    }
}
