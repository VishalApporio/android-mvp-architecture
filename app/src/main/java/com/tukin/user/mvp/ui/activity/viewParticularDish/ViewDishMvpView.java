package com.tukin.user.mvp.ui.activity.viewParticularDish;

import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by lenovo on 4/26/2018.
 */

public interface ViewDishMvpView extends MvpView {

    void viewDishDetailsMethod();

    void checkDetailsInDatabase();

    void openViewCartActivity();

    void showCheckOutButton(String check,List<ProductDatadb> productDatadbList,String user_id);
}