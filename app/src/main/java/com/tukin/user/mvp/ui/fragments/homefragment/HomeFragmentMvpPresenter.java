package com.tukin.user.mvp.ui.fragments.homefragment;

import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/11/2018.
 */

@PerActivity
public interface HomeFragmentMvpPresenter<V extends HomeFragmentMvpView> extends MvpPresenter<V> {

    void onViewAllRestuaranents();

    void updatePlayerid();
}
