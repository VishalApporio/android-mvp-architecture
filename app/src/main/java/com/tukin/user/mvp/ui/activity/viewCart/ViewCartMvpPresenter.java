package com.tukin.user.mvp.ui.activity.viewCart;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 5/5/2018.
 */

public interface ViewCartMvpPresenter <V extends ViewCartMvpView> extends MvpPresenter<V> {

    void callAPiForViewCart();

    void callApiForPlaceOrder();
}
