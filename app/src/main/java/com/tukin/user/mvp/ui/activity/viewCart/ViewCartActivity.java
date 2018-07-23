package com.tukin.user.mvp.ui.activity.viewCart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.ViewCartResponse;
import com.tukin.user.mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewCartActivity extends BaseActivity implements ViewCartMvpView {

    @Inject
    ViewCartMvpPresenter<ViewCartMvpView> mPresenter;

    @BindView(R.id.tv_Category_name)
    TextView tv_Category_name;

    @BindView(R.id.tv_Category_details)
    TextView tv_Category_details;

    @BindView(R.id.tv_total_amount)
    TextView tv_total_amount;

    @BindView(R.id.tv_address)
    TextView tv_address;

    @BindView(R.id.tool_bar)
    Toolbar mToolbar;

    @BindView(R.id.place_holder)
    PlaceHolderView placeHolderView;

    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @BindView(R.id.ll_empty_view)
    LinearLayout ll_empty_view;

    @BindView(R.id.btn_place_order)
    Button btn_place_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);


        bindActivity();
    }

    private void bindActivity() {
        setSupportActionBar(mToolbar);
        getActivityComponent().inject(this);
        mPresenter.onAttach(ViewCartActivity.this);
        mPresenter.callAPiForViewCart();

        setUp();
    }

    @Override
    protected void setUp() {

        setUnBinder(ButterKnife.bind(this));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("View Cart");

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick(R.id.btn_place_order)
    void onClickForPlaceOrder(View v) {
        mPresenter.callApiForPlaceOrder();
    }

    @Override
    public void viewCartDetails(ViewCartResponse viewCartResponse, String address) {

        if (viewCartResponse.getResult() == 1) {
            btn_place_order.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.VISIBLE);
            ll_empty_view.setVisibility(View.GONE);
            tv_address.setText(address);
            tv_Category_name.setText(viewCartResponse.getResponse().getRestauranent_name().toString());
            tv_Category_details.setText(viewCartResponse.getResponse().getAvailability_time());
            tv_total_amount.setText("$" + viewCartResponse.getResponse().getTotal_Amount());

            for (int i = 0; i < viewCartResponse.getResponse().getProducts_Data().size(); i++) {

                placeHolderView.addView(new ViewForProductsCart(this, viewCartResponse.getResponse().getProducts_Data().get(i)));
            }
        } else {
            btn_place_order.setVisibility(View.GONE);
            scrollView.setVisibility(View.GONE);
            ll_empty_view.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void finishViewCartActivity() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Your Order is Successfully Placed");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ViewCartActivity.this.finish();
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

}
