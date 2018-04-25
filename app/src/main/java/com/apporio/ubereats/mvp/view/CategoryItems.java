package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.AllProductsResponse;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

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


    Context context;
    AllProductsResponse.ResponseBean.CategoriesBean.CategoryProductsBean allProductsResponse;

    public CategoryItems(Context context, AllProductsResponse.ResponseBean.CategoriesBean.CategoryProductsBean allProductsResponse,int position) {
        this.context = context;
        this.allProductsResponse = allProductsResponse;
    }

    @Resolve
    private void onResolved() {

            if (allProductsResponse.getIn_stock().equals("")) {
                ll_available.setVisibility(android.view.View.VISIBLE);
                ll_availability_text.setVisibility(android.view.View.VISIBLE);
            } else {
                ll_available.setVisibility(android.view.View.GONE);
                ll_availability_text.setVisibility(android.view.View.GONE);
            }
            tv_product_name.setText(allProductsResponse.getProduct_name().toString());
            tv_product_price.setText("$" + " " + allProductsResponse.getProduct_price());

            if (allProductsResponse.getProduct_description().toString().equals("")) {
                tv_product_description.setVisibility(android.view.View.GONE);
            } else {
                tv_product_description.setText("" + allProductsResponse.getProduct_description().toString());

            }

            if (allProductsResponse.isVergetarial()) {
                tv_product_type.setText("" + allProductsResponse.getVergetarial_text().toString());
            } else {
                tv_product_type.setVisibility(android.view.View.GONE);
            }
            if (!allProductsResponse.getProduct_image().toString().equals("")) {
                Glide.with(context).load("" + allProductsResponse.getProduct_image().toString()).into(iv_product_image);
            }
        }

    }
