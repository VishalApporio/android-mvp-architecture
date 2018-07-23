package com.tukin.user.mvp.ui.activity.viewProducts;

import com.tukin.user.mvp.ui.base.MvpPresenter;

/**
 * Created by lenovo on 4/24/2018.
 */

public interface ViewProductsMvpPresenter<V extends ViewProductsMvpView> extends MvpPresenter<V> {

    void callApiForViewAllProducts(String category_id);
}
