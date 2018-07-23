package com.tukin.user.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tukin.user.R;
import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;
import com.tukin.user.mvp.ui.activity.viewProducts.ViewProductsActivity;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by lenovo on 4/11/2018.
 */

@Layout(R.layout.more_restauranent_view)
public class MoreResturanentView {

    Context mContext;
    ViewResturanentsModel.ResponseBean.ScrollerAllDataBean mScrollAllDataBean;
    @View(R.id.placeholder)
    PlaceHolderView placeholder;
    @View(R.id.tv_view_name)
    TextView tv_view_name;


    public MoreResturanentView(Context context, ViewResturanentsModel.ResponseBean.ScrollerAllDataBean scrollerAllDataBean) {
        mContext = context;
        mScrollAllDataBean = scrollerAllDataBean;
    }

    @Resolve
    private void onResolved() {
//
//        for (int i = 0; i < mScrollAllDataBean.getScroller_data().size(); i++) {
//
//            placeholder.addView(new HolderMoreRestauranent(mContext, mScrollAllDataBean.getScroller_data().get(i)));
//
//        }
//
//        tv_view_name.setText(mScrollAllDataBean.getView_scroller_name().toString());
    }

    @Layout(R.layout.layout_more_rest)
    public class HolderMoreRestauranent {

        Context mContext;
        //  ViewResturanentsModel.ResponseBean.ScrollerAllDataBean.ScrollerDataBean mScrollDataBean;

        @View(R.id.iv_rest_image)
        AppCompatImageView iv_rest_image;
        @View(R.id.iv_rest_fav)
        AppCompatImageView iv_rest_fav;
        @View(R.id.tv_rest_name)
        TextView tv_rest_name;
        @View(R.id.tv_rest_timing)
        TextView tv_rest_timing;
        @View(R.id.tv_rest_type)
        TextView tv_rest_type;
        @View(R.id.tv_rest_rating)
        TextView tv_rest_rating;
        boolean favorite;
        @View(R.id.rl_available)
        RelativeLayout rl_available;
        @View(R.id.tv_available_text)
        TextView tv_available_text;
//
//        public HolderMoreRestauranent(Context context, ViewResturanentsModel.ResponseBean.ScrollerAllDataBean.ScrollerDataBean scrollerDataBean) {
//
//            mContext = context;
//            mScrollDataBean = scrollerDataBean;
//        }

        @Resolve
        private void onResolved() {

//            tv_rest_name.setText(mScrollDataBean.getRestauranent_name().toString());
//            tv_rest_timing.setText(mScrollDataBean.getAverage_delivery_time().toString());
//            tv_rest_rating.setText(mScrollDataBean.getRating().toString() + " " + "(" + mScrollDataBean.getRate_out_of().toString() + ")");
//
//            if (mScrollDataBean.isFavourite() == true) {
//                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
//            } else {
//                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
//            }
//
//            if(mScrollDataBean.isAvailability() == false){
//                rl_available.setVisibility(android.view.View.VISIBLE);
//                tv_available_text.setText(mScrollDataBean.getAvailability_text().toString());
//            }else {
//                rl_available.setVisibility(android.view.View.GONE);
//            }
//
//
//            if (!mScrollDataBean.getRestauranent_image().toString().equals("")) {
//                Glide.with(mContext).load("" + mScrollDataBean.getRestauranent_image().toString()).into(iv_rest_image);
//            }
//
//            for (int i = 0; i < mScrollDataBean.getRestauranent_styles().size(); i++) {
//
//                tv_rest_type.setText(" " + mScrollDataBean.getRestauranent_styles().get(i).getStyle_name().toString());
//            }
//        }
//
//        @Click(R.id.iv_rest_fav)
//        private void onClickFavorite() {
//            if (favorite) {
//                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
//                favorite = false;
//            } else {
//                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
//                favorite = true;
//            }
//        }
//
//        @Click(R.id.ll_category)
//        private void onClick() {
//            if(mScrollDataBean.isAvailability() == true){
//                mContext.startActivity(new Intent(mContext, ViewProductsActivity.class));
//            }        }

        }
    }
}
