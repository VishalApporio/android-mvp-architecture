package com.tukin.user.mvp.ui.activity.profile;

import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface ProfileMvpView extends MvpView {

    void updateUserProfileDetails(String first_name, String last_name, String email, String phone_no ,String user_image);

    void openChangePhoneNumberActivity();

}
