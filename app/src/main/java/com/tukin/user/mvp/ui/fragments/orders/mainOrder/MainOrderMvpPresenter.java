package com.tukin.user.mvp.ui.fragments.orders.mainOrder;

import com.tukin.user.mvp.ui.base.MvpPresenter;
import com.tukin.user.mvp.ui.fragments.homefragment.HomeFragmentMvpView;

/**
 * Created by lenovo on 5/7/2018.
 */

public interface MainOrderMvpPresenter<V extends MainOrderMvpView> extends MvpPresenter<V> {

    void viewAllOrderResponse();
}
