

package com.tukin.user.mvp.ui.activity.login;


import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
