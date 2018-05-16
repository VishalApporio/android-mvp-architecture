

package com.apporio.ubereats.mvp.ui.activity.login;


import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 27/01/17.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
