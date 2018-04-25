package com.apporio.ubereats.mvp.ui.activity.profile;

import com.androidnetworking.error.ANError;
import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.DataManager;
import com.apporio.ubereats.mvp.data.network.model.LoginResponse;
import com.apporio.ubereats.mvp.ui.base.BasePresenter;
import com.apporio.ubereats.mvp.utils.CommonUtils;
import com.apporio.ubereats.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by lenovo on 4/18/2018.
 */

public class ProfilePresenter<V extends ProfileMvpView> extends BasePresenter<V>
        implements ProfileMvpPresenter<V> {

    @Inject
    public ProfilePresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewProfileDetails() {

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doViewProfileApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {

                        getDataManager().updateUserInfo(
                                response.getResponse().getSession_token(),
                                response.getResponse().getUser_id(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getResponse().getUser_first_name(),
                                response.getResponse().getUser_email(),
                                response.getResponse().getUser_image());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().updateUserProfileDetails(response.getResponse().getUser_first_name(),
                                response.getResponse().getUser_last_name(),
                                response.getResponse().getUser_email(),
                                response.getResponse().getUser_phone(),
                                response.getResponse().getUser_image());

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
    public void onClickSubmitButton(String user_image, String user_first_name, String user_last_name, String user_email, String user_phone) {


        if (user_image == null || user_image.isEmpty()) {
            getMvpView().onError(R.string.empty_user_image);
            return;
        } else if (user_first_name == null || user_first_name.isEmpty()) {
            getMvpView().onError(R.string.empty_first_name);
            return;
        } else if (user_last_name == null || user_last_name.isEmpty()) {
            getMvpView().onError(R.string.empty_last_name);
            return;
        } else if (user_email == null || user_email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        } else if (!CommonUtils.isEmailValid(user_email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        } else if (user_phone == null || user_phone.isEmpty()) {
            getMvpView().onError(R.string.empty_phone_no);
            return;
        }

        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doViewProfileApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {

                        getDataManager().updateUserInfo(
                                response.getResponse().getSession_token(),
                                response.getResponse().getUser_id(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getResponse().getUser_first_name(),
                                response.getResponse().getUser_email(),
                                response.getResponse().getUser_image());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().showMessage("Profile Updated");
                        getMvpView().updateUserProfileDetails(response.getResponse().getUser_first_name(),
                                response.getResponse().getUser_last_name(),
                                response.getResponse().getUser_email(),
                                response.getResponse().getUser_phone(),
                                response.getResponse().getUser_image());

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
    public void onClickPhoneNumberlayout() {

        getMvpView().openChangePhoneNumberActivity();
    }
}
