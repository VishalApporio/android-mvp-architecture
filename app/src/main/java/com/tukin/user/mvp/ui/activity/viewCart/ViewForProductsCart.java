package com.tukin.user.mvp.ui.activity.viewCart;

import android.content.Context;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.ViewCartResponse;

/**
 * Created by lenovo on 5/5/2018.
 */

@Layout(R.layout.view_for_product_cart)
public class ViewForProductsCart {

    @View(R.id.tv_product_name)
    TextView tv_product_name;

    @View(R.id.tv_product_quantity)
    TextView tv_product_quantity;

    @View(R.id.tv_price)
    TextView tv_price;

    ViewCartResponse.ResponseBean.ProductsDataBean productsDataBean;
    Context context;

    public ViewForProductsCart(Context context, ViewCartResponse.ResponseBean.ProductsDataBean productsDataBean) {
        this.context = context;
        this.productsDataBean = productsDataBean;
    }

    @Resolve
    private void onResolved() {

        tv_product_quantity.setText(productsDataBean.getProduct_quantity());
        tv_product_name.setText(productsDataBean.getProduct_name());
        tv_price.setText("$" + productsDataBean.getProduct_price());

    }

}
