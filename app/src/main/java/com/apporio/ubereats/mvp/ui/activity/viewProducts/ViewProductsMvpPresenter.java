package com.apporio.ubereats.mvp.ui.activity.viewProducts;

import com.apporio.ubereats.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/24/2018.
 */

public interface ViewProductsMvpPresenter<V extends ViewProductsMvpView> extends MvpPresenter<V> {

    void callApiForViewAllProducts();
}
