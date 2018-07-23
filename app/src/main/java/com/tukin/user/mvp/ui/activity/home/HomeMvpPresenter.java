package com.tukin.user.mvp.ui.activity.home;

import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/11/2018.
 */

@PerActivity
public interface HomeMvpPresenter <V extends HomeMvpView> extends MvpPresenter<V> {

}
