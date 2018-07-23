

package com.tukin.user.mvp.ui.main;


import com.tukin.user.mvp.di.PerActivity;
import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 05/03/18.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onDrawerOptionAboutClick();

    void onDrawerOptionLogoutClick();

    void onDrawerRateUsClick();

    void onDrawerMyFeedClick();

    void onViewInitialized();

    void onCardExhausted();

    void onNavMenuCreated();
}
