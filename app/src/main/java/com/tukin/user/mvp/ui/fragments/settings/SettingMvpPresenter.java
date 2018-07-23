package com.tukin.user.mvp.ui.fragments.settings;

import android.support.v7.widget.AppCompatImageView;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface SettingMvpPresenter <V extends SettingsMvpView> extends MvpPresenter<V> {

    void onOptionLogoutClick();

    void getUserInformation();
}
