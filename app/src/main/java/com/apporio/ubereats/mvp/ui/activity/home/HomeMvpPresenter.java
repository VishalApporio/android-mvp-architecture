package com.apporio.ubereats.mvp.ui.activity.home;

import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.base.MvpPresenter;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragmentMvpView;

/**
 * Created by lenovo on 4/11/2018.
 */

@PerActivity
public interface HomeMvpPresenter <V extends HomeMvpView> extends MvpPresenter<V> {

}
