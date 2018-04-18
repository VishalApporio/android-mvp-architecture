package com.apporio.ubereats.mvp.ui.fragments.settings;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;
import com.apporio.ubereats.mvp.ui.main.MainMvpView;

/**
 * Created by lenovo on 4/18/2018.
 */

public interface SettingMvpPresenter <V extends SettingsMvpView> extends MvpPresenter<V> {

    void onOptionLogoutClick();
}
