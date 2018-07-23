package com.tukin.user.mvp.ui.fragments.orders.views.viewsForHistory;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.orderHistory.CompletedOrder;
import com.tukin.user.mvp.data.network.ApiEndPoint;

/**
 * Created by lenovo on 5/8/2018.
 */

@Layout(R.layout.history_order_view)
public class HolderViewForPast {

    Context mContext;
    PlaceHolderView mPlaceHolderView;
    CompletedOrder mMsg;

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

    public HolderViewForPast(FragmentActivity activity, PlaceHolderView placeHolder, CompletedOrder completedOrder) {
        mContext = activity;
        mPlaceHolderView = placeHolder;
        mMsg = completedOrder;
    }

    @Resolve
    private void onResolved() {
        tv_category_name.setText(mMsg.getCategory().getCategoryName().toString());
        tv_order_id.setText("Order" + " " + mMsg.getOrderId().toString());
        tv_total_price.setText("Total:" + " " + "$" + mMsg.getTotalAmount().toString());
        text_track.setVisibility(android.view.View.GONE);

        if (mMsg.getOrderStatus().equals("1")) {
            tv_order_status.setText("New Order");
        } else if (mMsg.getOrderStatus().equals("3")) {
            tv_order_status.setText("Order Prepared");
        } else if (mMsg.getOrderStatus().equals("5")) {
            tv_order_status.setText("Order On the way");
        } else if (mMsg.getOrderStatus().equals("6")) {
            tv_order_status.setText("Order On the way");
        } else if (mMsg.getOrderStatus().equals("7")) {
            tv_order_status.setText("Order Deilvered");
        }


        for (int i = 0; i < mMsg.getCategory().getCategoryProducts().size(); i++) {
            place_holder.addView(new HolderViewForPastProducts(mContext, mMsg.getCategory().getCategoryProducts().get(i)));
        }

        Glide.with(mContext)
                .load(ApiEndPoint.ENDPOINT_FOR_IMAGE + mMsg.getCategory().getCategoryImage().toString())
                .asBitmap()
                .centerCrop()
                .into(iv_category_image);
    }
}
