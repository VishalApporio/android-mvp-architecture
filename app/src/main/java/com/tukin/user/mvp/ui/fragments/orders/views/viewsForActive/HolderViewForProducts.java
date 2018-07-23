package com.tukin.user.mvp.ui.fragments.orders.views.viewsForActive;

import android.content.Context;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.orderHistory.CategoryProduct;
import com.tukin.user.mvp.data.db.model.orderHistory.CategoryProduct_;

/**
 * Created by lenovo on 5/8/2018.
 */

@Layout(R.layout.item_view_for_products)
public class HolderViewForProducts {

    CategoryProduct_ mcategoryProduct;
    Context mContext;

    @View(R.id.tv_product_quantity)
    TextView tv__product_quantity;
    @View(R.id.tv_product_name)
    TextView tv_product_name;


    public HolderViewForProducts(Context context, CategoryProduct_ categoryProduct) {
        mContext = context;
        mcategoryProduct = categoryProduct;
    }


    @Resolve
    private void onResolved() {

        tv__product_quantity.setText(mcategoryProduct.getProductQuantity().toString());
        tv_product_name.setText(mcategoryProduct.getProductName().toString());
    }
}
