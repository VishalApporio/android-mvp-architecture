package com.tukin.user.mvp.ui.activity.viewParticularDish;

import com.tukin.user.mvp.ui.base.MvpPresenter;

import org.json.JSONArray;

/**
 * Created by lenovo on 4/26/2018.
 */

public interface ViewDishMvpPresenter<V extends ViewDishMvpView> extends MvpPresenter<V> {

    void saveProductDetailsTODatabase(String category_id,String sub_category_id,Integer product_id, String product_name, Integer product_quantity, String product_price, Integer total_price);

    void isProductDetailsAvailable();

    void clearDatabaseithCheckOut(JSONArray jsonArray);

}

