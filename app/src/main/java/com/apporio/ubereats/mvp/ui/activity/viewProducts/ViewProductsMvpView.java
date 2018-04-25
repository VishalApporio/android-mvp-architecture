package com.apporio.ubereats.mvp.ui.activity.viewProducts;

import com.apporio.ubereats.mvp.data.network.model.AllProductsResponse;
import com.apporio.ubereats.mvp.ui.base.MvpView;

/**
 * Created by lenovo on 4/24/2018.
 */

public interface ViewProductsMvpView extends MvpView {

    void viewAllRestauranentProducts(AllProductsResponse allProductsResponse);

}
