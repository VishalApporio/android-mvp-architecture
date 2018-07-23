package com.tukin.user.mvp.ui.fragments.orders.views.viewsForActive;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.orderHistory.OngoingOrder;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.ui.activity.trackRide.TrackRideActivty;

/**
 * Created by lenovo on 5/8/2018.
 */

@Layout(R.layout.history_order_view)
public class HolderViewForOrder {

    Context mContext;
    PlaceHolderView mPlaceHolderView;
    OngoingOrder mMsg;

    @View(R.id.tv_category_name)
    TextView tv_category_name;
    @View(R.id.tv_order_id)
    TextView tv_order_id;
    @View(R.id.tv_order_status)
    TextView tv_order_status;
    @View(R.id.tv_total_price)
    TextView tv_total_price;
    @View(R.id.place_holder)
    PlaceHolderView place_holder;
    @View(R.id.iv_category_image)
    ImageView iv_category_image;
    @View(R.id.text_track)
    TextView text_track;

    public HolderViewForOrder(FragmentActivity activity, PlaceHolderView placeHolder, OngoingOrder completedOrder) {
        mContext = activity;
        mPlaceHolderView = placeHolder;
        mMsg = completedOrder;
    }

    @Resolve
    private void onResolved() {
        tv_category_name.setText(mMsg.getCategory().getCategoryName().toString());
        tv_order_id.setText("Order" + " " + mMsg.getOrderId().toString());
        tv_total_price.setText("Total:" + " " + "$" + mMsg.getTotalAmount().toString());

        if (mMsg.getOrderStatus().equals("1")) {
            text_track.setVisibility(android.view.View.GONE);
            tv_order_status.setText("New Order");
        } else if (mMsg.getOrderStatus().equals("3")) {
            text_track.setVisibility(android.view.View.GONE);
            tv_order_status.setText("Order Prepared");
        } else if (mMsg.getOrderStatus().equals("5")) {
            text_track.setVisibility(android.view.View.VISIBLE);
            tv_order_status.setText("Order On the way");
        } else if (mMsg.getOrderStatus().equals("6")) {
            text_track.setVisibility(android.view.View.VISIBLE);
            tv_order_status.setText("Order On the way");
        } else if (mMsg.getOrderStatus().equals("7")) {
            text_track.setVisibility(android.view.View.GONE);
            tv_order_status.setText("Order Deilvered");
        }


        place_holder.removeAllViews();
        for (int i = 0; i < mMsg.getCategory().getCategoryProducts().size(); i++) {
            place_holder.addView(new HolderViewForProducts(mContext, mMsg.getCategory().getCategoryProducts().get(i)));
        }

        Glide.with(mContext)
                .load(ApiEndPoint.ENDPOINT_FOR_IMAGE + mMsg.getCategory().getCategoryImage().toString())
                .asBitmap()
                .centerCrop()
                .into(iv_category_image);
    }

    @Click(R.id.text_track)
    void onClickTrack() {
        mContext.startActivity(new Intent(mContext, TrackRideActivty.class)
        .putExtra("order_id",mMsg.getOrderId().toString()));
    }
}
