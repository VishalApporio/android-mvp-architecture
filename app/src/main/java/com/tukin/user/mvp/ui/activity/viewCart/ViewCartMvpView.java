package com.tukin.user.mvp.ui.activity.viewCart;

import com.tukin.user.mvp.data.db.model.ViewCartResponse;
import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 5/5/2018.
 */

public interface ViewCartMvpView extends MvpView {


    void viewCartDetails(ViewCartResponse viewCartResponse,String address);

    void finishViewCartActivity();

}
