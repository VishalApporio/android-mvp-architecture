package com.tukin.user.mvp.ui.activity.register;

import com.androidnetworking.error.ANError;
import com.tukin.user.R;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.LoginRequest;
import com.tukin.user.mvp.data.network.model.LoginResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.CommonUtils;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lenovo on 4/11/2018.
 */

public class RegisterPresenter <V extends RegisterMvpView> extends BasePresenter<V>
        implements RegisterMvpPresenter<V> {

    @Inject
    public RegisterPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerRegister(String first_name, String last_name, String email, String phone_no, String password) {

        if (first_name == null || first_name.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (last_name == null || last_name.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (phone_no == null || phone_no.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }


        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doServerRegisterApiCall(new LoginRequest.ServerRegisterRequest(first_name,last_name,email,phone_no, password,"","1","1"))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new io.reactivex.functions.Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {

                        getDataManager().updateUserInfo(
                                response.getDetails().getSession_token(),
                                Long.valueOf(response.getDetails().getUser_id()),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getDetails().getUser_name(),
                                response.getDetails().getUser_email(),
                                response.getDetails().getUser_image());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();

                    }
                }, new io.reactivex.functions.Consumer<Throwable>() {
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
