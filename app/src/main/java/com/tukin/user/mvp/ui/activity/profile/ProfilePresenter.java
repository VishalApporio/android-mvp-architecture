package com.tukin.user.mvp.ui.activity.profile;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.tukin.user.R;
import com.tukin.user.mvp.data.DataManager;
import com.tukin.user.mvp.data.network.model.LoginResponse;
import com.tukin.user.mvp.ui.base.BasePresenter;
import com.tukin.user.mvp.utils.CommonUtils;
import com.tukin.user.mvp.utils.rx.SchedulerProvider;

import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
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

        String user_id = getDataManager().getCurrentUserId().toString();

        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("language_code", "" + "1");

        getCompositeDisposable().add(getDataManager()
                .doViewProfileApiCall(data)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
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
                        getMvpView().updateUserProfileDetails(response.getDetails().getUser_name(),
                                "",
                                response.getDetails().getUser_email(),
                                response.getDetails().getUser_phone(),
                                response.getDetails().getUser_image());

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
    public void onClickSubmitButton(String user_first_name, String user_last_name, String user_email, String user_phone,String imagePathCompressed) {

        Log.e("ImagePathCompressed",""+ imagePathCompressed);

        if (imagePathCompressed == null || imagePathCompressed.isEmpty()) {
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

        HashMap<String, File> image = new HashMap<String, File>();
        image.put("user_image" , new File(imagePathCompressed));



        String user_id = getDataManager().getCurrentUserId().toString();


        HashMap<String, String> data = new HashMap<>();
        data.put("user_id", "" + user_id);
        data.put("user_phone", "" + user_phone);
        data.put("user_first_name", "" + user_first_name);
        data.put("user_last_name", "" + user_last_name);
        data.put("user_email", "" + user_email);
        data.put("language_code", "" + "1");

        getCompositeDisposable().add(getDataManager()
                .doEditProfileApiCall(data,image)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
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
                        getMvpView().showMessage("Profile Updated");
                        getMvpView().updateUserProfileDetails(response.getDetails().getUser_name(),
                                "",
                                response.getDetails().getUser_email(),
                                response.getDetails().getUser_phone(),
                                response.getDetails().getUser_image());

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
