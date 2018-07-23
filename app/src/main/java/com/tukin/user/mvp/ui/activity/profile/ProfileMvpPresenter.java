package com.tukin.user.mvp.ui.activity.profile;
import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface ProfileMvpPresenter<V extends ProfileMvpView> extends MvpPresenter<V> {

    void onViewProfileDetails();

    void onClickSubmitButton(String user_first_name,String user_last_name,String user_email,String user_phone,String imagePathCompressed);

    void onClickPhoneNumberlayout();
}
