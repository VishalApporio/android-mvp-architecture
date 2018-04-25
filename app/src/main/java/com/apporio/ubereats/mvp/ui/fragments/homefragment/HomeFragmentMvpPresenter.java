package com.apporio.ubereats.mvp.ui.fragments.homefragment;

import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/11/2018.
 */

@PerActivity
public interface HomeFragmentMvpPresenter<V extends HomeFragmentMvpView> extends MvpPresenter<V> {

    void onViewAllRestuaranents();
}
