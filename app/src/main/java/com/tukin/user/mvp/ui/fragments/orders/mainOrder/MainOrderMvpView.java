package com.tukin.user.mvp.ui.fragments.orders.mainOrder;

import com.tukin.user.mvp.data.db.model.orderHistory.OrderHistoryResponse;
import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 5/7/2018.
 */

public interface MainOrderMvpView extends MvpView {

    void viewAllHistoryResponse(OrderHistoryResponse orderHistoryResponse);
}
