package com.tukin.user.mvp.ui.fragments.settings;

import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface SettingsMvpView extends MvpView {

    void openLoginActivity();

    void updateUserInformation(String user_image,String user_name);

}
