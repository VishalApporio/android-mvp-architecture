package com.apporio.ubereats.mvp.ui.activity.viewParticularDish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.CategoryProduct;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.apporio.ubereats.mvp.view.ViewForCheckButton;
import com.apporio.ubereats.mvp.view.ViewForRadioButton;
import com.apporio.ubereats.mvp.view.ViewForSpecialInstructions;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDishActivity extends BaseActivity implements ViewDishMvpView {

    @Inject
    ViewDishMvpPresenter<ViewDishMvpView> mPresenter;


    CategoryProduct categoryProduct;

    @BindView(R.id.place_holder)
    PlaceHolderView place_holder;
    @BindView(R.id.iv_dish_image)
    ImageView iv_dish_image;
    @BindView(R.id.tv_dish_name)
    TextView tv_dish_name;
    @BindView(R.id.tv_dish_details)
    TextView tv_dish_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dish);


        bindActivity();
        setUnBinder(ButterKnife.bind(this));


        categoryProduct = (CategoryProduct) getIntent().getSerializableExtra("DishResponse");

        Log.e("AllData", "" + categoryProduct.getProductName().toString());

        viewDishDetailsMethod();

        for (int i = 0; i < categoryProduct.getSelectors().size(); i++) {
            if (categoryProduct.getSelectors().get(i).getSelectorType().equals("checkbox")) {
                place_holder.addView(new ViewForCheckButton(ViewDishActivity.this, categoryProduct, i));
            } else if (categoryProduct.getSelectors().get(i).getSelectorType().equals("radio")) {
                place_holder.addView(new ViewForRadioButton(ViewDishActivity.this, categoryProduct, i));
            }
        }
        place_holder.addView(new ViewForSpecialInstructions());


    }

    @Override
    protected void setUp() {
    }

    private void bindActivity() {
        getActivityComponent().inject(ViewDishActivity.this);
        mPresenter.onAttach(ViewDishActivity.this);
    }

    @Override
    public void viewDishDetailsMethod() {

        tv_dish_name.setText(categoryProduct.getProductName().toString());
        tv_dish_details.setText(categoryProduct.getProductDescription().toString());

        Glide.with(ViewDishActivity.this).load("" + categoryProduct.getProductImage().toString()).into(iv_dish_image);


    }
}
