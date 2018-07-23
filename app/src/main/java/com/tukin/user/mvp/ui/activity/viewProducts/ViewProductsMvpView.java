package com.tukin.user.mvp.ui.activity.viewProducts;

import com.tukin.user.mvp.data.network.model.productResponse.ViewProductResponse;
import com.tukin.user.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/24/2018.
 */

public interface ViewProductsMvpView extends MvpView {

    void viewAllRestauranentProducts(ViewProductResponse allProductsResponse);

}
