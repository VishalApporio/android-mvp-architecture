package com.tukin.user.mvp.ui.activity.viewParticularDish;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.DaoSession;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.data.network.model.productResponse.CategoryProduct;
import com.tukin.user.mvp.di.others.events.GetAllProductInformationEvent;
import com.tukin.user.mvp.di.others.events.RemoveProductInformationEvent;
import com.tukin.user.mvp.ui.activity.viewCart.ViewCartActivity;
import com.tukin.user.mvp.ui.base.BaseActivity;
import com.tukin.user.mvp.view.ViewForSpecialInstructions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDishActivity extends BaseActivity implements ViewDishMvpView, ViewForSpecialInstructions.OncategorySelected {

    @Inject
    ViewDishMvpPresenter<ViewDishMvpView> mPresenter;


    CategoryProduct categoryProduct;
    private DaoSession mDaoSession;


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
    @BindView(R.id.tv_price_text)
    TextView tv_price_text;

    @BindView(R.id.ll_checkout)
    LinearLayout ll_checkout;
    @BindView(R.id.ll_add_to_database)
    LinearLayout ll_add_to_database;

    ArrayList<String> selectorIdList;
    ArrayList<String> selector_name;
    ArrayList<String> selector_price;

    Integer product_id, product_quantitiy;
    String product_name, category_price, new_category_price, product_price;
    Integer total_price;
    String category_id, sub_category_id, user_idd;
    List<ProductDatadb> mProductDatadbList;

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

//        for (int i = 0; i < categoryProduct.getSelectors().size(); i++) {
//            place_holder.addView(new ViewForRadioButton(ViewDishActivity.this, categoryProduct, i));
//        }
        place_holder.addView(new ViewForSpecialInstructions(this, place_holder, this));


    }

    @Override
    protected void setUp() {
    }

    private void bindActivity() {
        getActivityComponent().inject(ViewDishActivity.this);
        mPresenter.onAttach(ViewDishActivity.this);

        EventBus.getDefault().register(this);


        category_id = getIntent().getStringExtra("category_id");
        sub_category_id = getIntent().getStringExtra("sub_category_id");

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

        mPresenter.isProductDetailsAvailable();
    }

    @OnClick(R.id.ll_add_to_database)
    void onClickForAddDetails(View v) {
        if(product_quantitiy == null ||product_quantitiy == 0 || String.valueOf(product_quantitiy).equals("")){
            mPresenter.saveProductDetailsTODatabase(category_id, sub_category_id, product_id, product_name, 1, product_price, total_price);
        }else {
            mPresenter.saveProductDetailsTODatabase(category_id, sub_category_id, product_id, product_name, product_quantitiy, product_price, total_price);
        }
    }

    @OnClick(R.id.ll_checkout)
    void onClickForCheckOut(View v) {

        JSONArray jsonArray = new JSONArray();
        try {
            Log.d("inside try ", "rrr");
            for (int i = 0; i < mProductDatadbList.size(); i++) {

                JSONObject jinnerobject = new JSONObject();
                //logger.Logger.e("product names"+cartdata.get(i).getProductaName());
                jinnerobject.put("user_id", user_idd);
                jinnerobject.put("category_id", mProductDatadbList.get(i).getCategory_id());
                jinnerobject.put("sub_category_id", mProductDatadbList.get(i).getSubb_category_id());
                jinnerobject.put("product_id", mProductDatadbList.get(i).getProduct_id());
                jinnerobject.put("quantity", mProductDatadbList.get(i).getProduct_quantity());
                jsonArray.put(jinnerobject);
            }
            Log.e("JSONARRAY ", jsonArray.toString());

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("inside catch", "rrr");
        }

        mPresenter.clearDatabaseithCheckOut(jsonArray);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void viewDishDetailsMethod() {

        tv_dish_name.setText(categoryProduct.getProductName());
        tv_dish_details.setText(categoryProduct.getProductDescription());

        Glide.with(ViewDishActivity.this).load(ApiEndPoint.ENDPOINT_FOR_IMAGE + categoryProduct.getProductImage()).into(iv_dish_image);

        product_id = Integer.parseInt(categoryProduct.getProductId());
        product_name = categoryProduct.getProductName();
        product_price = categoryProduct.getProductPrice();

        tv_price_text.setText("$" + " " + product_price);
    }

    @Override
    public void checkDetailsInDatabase() {
        mPresenter.isProductDetailsAvailable();
    }

    @Override
    public void openViewCartActivity() {

        startActivity(new Intent(ViewDishActivity.this, ViewCartActivity.class));
        finish();
    }

    @Override
    public void showCheckOutButton(String check, List<ProductDatadb> productDatadbList, String user_id) {

        user_idd = user_id;
        if (check.equals("0")) {
            mProductDatadbList = productDatadbList;
            ll_add_to_database.setVisibility(View.GONE);
            ll_checkout.setVisibility(View.VISIBLE);
        } else {
            ll_add_to_database.setVisibility(View.VISIBLE);
            ll_checkout.setVisibility(View.GONE);
        }

    }

    @Override
    public void onAddSelected(int category_id) {
        Log.e("Category_id", "" + category_id);

        ll_add_to_database.setVisibility(View.VISIBLE);
        ll_checkout.setVisibility(View.GONE);

        tv_quantity_text.setText("Add" + " " + category_id + " " + "to cart");

        product_quantitiy = category_id;

        updatePriceMethod(product_quantitiy);
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

    }

    private void updatePriceMethod(Integer product_quantitiy) {

        Log.e("Quantity", "" + product_quantitiy);
        Log.e("ProductPrice", "" + product_price);

        total_price = Integer.parseInt(product_price) * product_quantitiy;

        Log.e("TotalPrice", "" + total_price);

        tv_price_text.setText("$" + " " + total_price);
    }


}
