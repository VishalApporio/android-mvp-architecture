package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.CategoryProduct;
import com.apporio.ubereats.mvp.ui.activity.viewParticularDish.ViewDishActivity;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by lenovo on 4/18/2018.
 */

@Layout(R.layout.category_view)
public class CategoryItems {

    @View(R.id.tv_product_name)
    TextView tv_product_name;

    @View(R.id.tv_product_price)
    TextView tv_product_price;

    @View(R.id.tv_product_description)
    TextView tv_product_description;

    @View(R.id.tv_product_type)
    TextView tv_product_type;

    @View(R.id.iv_product_image)
    ImageView iv_product_image;

    @View(R.id.ll_available)
    LinearLayout ll_available;

    @View(R.id.ll_availability_text)
    LinearLayout ll_availability_text;
    int position;

    @View(R.id.ll_dish)
            LinearLayout ll_dish;


    Context context;
    CategoryProduct allProductsResponse;

    public CategoryItems(Context context, CategoryProduct categoryProduct, int mCategoryPosition) {
        this.context = context;
        this.allProductsResponse = categoryProduct;
    }

    @Resolve
    private void onResolved() {

        if (allProductsResponse.getInStock().equals("")) {
            ll_available.setVisibility(android.view.View.VISIBLE);
            ll_availability_text.setVisibility(android.view.View.VISIBLE);
        } else {
            ll_available.setVisibility(android.view.View.GONE);
            ll_availability_text.setVisibility(android.view.View.GONE);
        }
        tv_product_name.setText(allProductsResponse.getProductName().toString());
        tv_product_price.setText("$" + " " + allProductsResponse.getProductPrice());

        if (allProductsResponse.getProductDescription().toString().equals("")) {
            tv_product_description.setVisibility(android.view.View.GONE);
        } else {
            tv_product_description.setText("" + allProductsResponse.getProductDescription().toString());

        }

        if (allProductsResponse.getVergetarial()) {
            tv_product_type.setText("" + allProductsResponse.getVergetarialText().toString());
        } else {
            tv_product_type.setVisibility(android.view.View.GONE);
        }
        if (!allProductsResponse.getProductImage().toString().equals("")) {
            Glide.with(context).load("" + allProductsResponse.getProductImage().toString()).into(iv_product_image);
        }


    }
//
    @Click(R.id.ll_dish)
    public void onClick() {

        Log.e("AllDataResponse", "" + allProductsResponse);

        if(!allProductsResponse.getInStock().equals("0")){
            context.startActivity(new Intent(context, ViewDishActivity.class)
                    .putExtra("DishResponse", allProductsResponse));

        }
//            Intent intent = ViewDishActivity.getStartIntent(context);
//            intent.putExtra("DishResponse",allProductsResponse);
//            context.startActivity(intent);
    }

}
