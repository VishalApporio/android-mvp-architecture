package com.tukin.user.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;
import com.tukin.user.mvp.location.LocationSession;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsActivity;

import javax.inject.Inject;

/**
 * Created by lenovo on 5/2/2018.
 */

@Layout(R.layout.home_category_item)
public class HolderForCategoryItem {

    @Inject
    LocationSession locationSession;

    @View(R.id.text_category)
    TextView text_category;
    @View(R.id.iv_category)
    ImageView iv_category;

    Context context;
    ViewResturanentsModel.ResponseBean.ScrollerAllDataBean scrollerAllDataBean;

    public HolderForCategoryItem(Context context, ViewResturanentsModel.ResponseBean.ScrollerAllDataBean scrollerAllDataBean) {
        this.context = context;
        this.scrollerAllDataBean = scrollerAllDataBean;
    }

    @Resolve
    public void onReolved() {

        text_category.setText(scrollerAllDataBean.getCategory_name().toString());
        Log.e("Image", "" + ApiEndPoint.ENDPOINT_FOR_IMAGE + scrollerAllDataBean.getCategory_icon());
        Glide.with(context)
                .load(ApiEndPoint.ENDPOINT_FOR_IMAGE + scrollerAllDataBean.getCategory_icon())
                .asBitmap()
                .centerCrop()
                .into(iv_category);

    }

    @Click(R.id.ll_category)
    private void onClick() {

        context.startActivity(new Intent(context, ViewProductsActivity.class)
                .putExtra("category_id", scrollerAllDataBean.getCategory_id().toString()));
//        if (locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT).equals("") || locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT).equals("null")) {
//
//            Toast.makeText(context, "Please select location first", Toast.LENGTH_SHORT).show();
//        } else {
//
//        }
    }

}
