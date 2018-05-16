package com.apporio.ubereats.mvp.ui.activity.viewParticularDish;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.CategoryProduct;
import com.apporio.ubereats.mvp.di.others.events.GetAllProductInformationEvent;
import com.apporio.ubereats.mvp.di.others.events.RemoveProductInformationEvent;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.apporio.ubereats.mvp.view.ViewForRadioButton;
import com.apporio.ubereats.mvp.view.ViewForSpecialInstructions;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDishActivity extends BaseActivity implements ViewDishMvpView, ViewForSpecialInstructions.OncategorySelected {

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
    @BindView(R.id.tv_quantity_text)
    TextView tv_quantity_text;
    ArrayList<String> selectorIdList;
    ArrayList<String> selector_name;
    ArrayList<String> selector_price;

    Integer product_quantitiy;
    String category_price, new_category_price, product_price;
    Double total_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dish);

        selectorIdList = new ArrayList<>();
        selector_name = new ArrayList<>();
        selector_price = new ArrayList<>();


        bindActivity();
        setUnBinder(ButterKnife.bind(this));


        categoryProduct = (CategoryProduct) getIntent().getSerializableExtra("DishResponse");

        Log.e("AllData", "" + categoryProduct.getProductName().toString());

        viewDishDetailsMethod();

        for (int i = 0; i < categoryProduct.getSelectors().size(); i++) {
            place_holder.addView(new ViewForRadioButton(ViewDishActivity.this, categoryProduct, i));
        }
        place_holder.addView(new ViewForSpecialInstructions(this, place_holder, this));


    }

    @Override
    protected void setUp() {
    }

    private void bindActivity() {
        getActivityComponent().inject(ViewDishActivity.this);
        mPresenter.onAttach(ViewDishActivity.this);

        EventBus.getDefault().register(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Dish Details");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void viewDishDetailsMethod() {

        tv_dish_name.setText(categoryProduct.getProductName().toString());
        tv_dish_details.setText(categoryProduct.getProductDescription().toString());

        Glide.with(ViewDishActivity.this).load("" + categoryProduct.getProductImage().toString()).into(iv_dish_image);

        product_price = categoryProduct.getProductPrice().toString();

    }

    @Override
    public void onAddSelected(int category_id) {
        Log.e("Category_id", "" + category_id);
        tv_quantity_text.setText("Add" + " " + category_id + " " + "to cart");

        product_quantitiy = category_id;

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent1(GetAllProductInformationEvent event) {

        Log.e("CategoryName", "" + event.getSelector_name().toString());
        Log.e("CategoryPrice", "" + event.getSelector_price().toString());


        selectorIdList.add(String.valueOf(event.getSelector_id().toString()));
        selector_name.add(event.getSelector_name().toString());
        selector_price.add(event.getSelector_price().toString());

        Log.e("SelectorIdArrayList", "" + selectorIdList);
        Log.e("SelectorNameArrayList", "" + selector_name);
        Log.e("SelectorPriceArrayList", "" + selector_price);


        updatePriceMethod(selector_price);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RemoveProductInformationEvent event) {

        if (selectorIdList.contains(event.getSelector_id().toString())) {
            selectorIdList.remove(String.valueOf(event.getSelector_id().toString()));
            selector_name.remove(event.getSelector_name().toString());
            selector_price.remove(event.getSelector_price().toString());
        }

        Log.e("SelectorIdArrayList", "" + selectorIdList);
        Log.e("SelectorNameArrayList", "" + selector_name);
        Log.e("SelectorPriceArrayList", "" + selector_price);

        updatePriceMethod(selector_price);
    }

    private void updatePriceMethod(ArrayList<String> selector_price1) {

        for (int i = 0; i < selector_price1.size(); i++) {

            total_price = total_price + Double.parseDouble(selector_price1.get(i)) + Double.parseDouble(product_price) * product_quantitiy;

        }
        Log.e("TotalPrice", "" + total_price);
    }


}
