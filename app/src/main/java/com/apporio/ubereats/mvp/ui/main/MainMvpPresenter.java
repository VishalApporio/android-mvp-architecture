

package com.apporio.ubereats.mvp.ui.main;


import com.apporio.ubereats.mvp.di.PerActivity;
import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by vishal@apporio.com on 27/01/17.
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
