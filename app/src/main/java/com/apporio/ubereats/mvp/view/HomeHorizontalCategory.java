package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.ui.activity.viewProducts.ViewProductsActivity;
import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by lenovo on 4/11/2018.
 */

@Layout(R.layout.home_view)
public class HomeHorizontalCategory {

    Context mContext;
    @View(R.id.placeholder)
    PlaceHolderView placeholder;
    @View(R.id.tv_view_name)
    TextView tv_view_name;
    ViewResturanentsModel.ResponseBean.ScrollerAllDataBean mScrollAllDataBean;

    public HomeHorizontalCategory(Context context, ViewResturanentsModel.ResponseBean.ScrollerAllDataBean scrollerAllDataBean) {
        mContext = context;
        mScrollAllDataBean = scrollerAllDataBean;
    }


    @Resolve
    private void onResolved() {

        placeholder.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        for (int i = 0; i < mScrollAllDataBean.getScroller_data().size(); i++) {

            placeholder.addView(new HolderCategoriesView(mContext, mScrollAllDataBean.getScroller_data().get(i)));

        }

        tv_view_name.setText(mScrollAllDataBean.getView_scroller_name().toString());
    }

    @Layout(R.layout.home_horizontal_view)
    public class HolderCategoriesView {

        Context mContext;
        ViewResturanentsModel.ResponseBean.ScrollerAllDataBean.ScrollerDataBean mScrollDataBean;
        boolean favorite;

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

        public HolderCategoriesView(Context context, ViewResturanentsModel.ResponseBean.ScrollerAllDataBean.ScrollerDataBean scrollerDataBean) {

            mContext = context;
            mScrollDataBean = scrollerDataBean;
        }

        @Resolve
        private void onResolved() {

            tv_rest_name.setText(mScrollDataBean.getRestauranent_name().toString());
            tv_rest_timing.setText(mScrollDataBean.getAverage_delivery_time().toString());
            tv_rest_rating.setText(mScrollDataBean.getRating().toString() + " " + "(" + mScrollDataBean.getRate_out_of().toString() + ")");

            if (mScrollDataBean.isFavourite() == true) {
                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
            } else {
                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
            }

            if (!mScrollDataBean.getRestauranent_image().toString().equals("")) {
                Glide.with(mContext).load("" + mScrollDataBean.getRestauranent_image().toString()).into(iv_rest_image);
            }

            for (int i = 0; i < mScrollDataBean.getRestauranent_styles().size(); i++) {

                tv_rest_type.setText(" " + mScrollDataBean.getRestauranent_styles().get(i).getStyle_name().toString());
            }
        }


        @Click(R.id.iv_rest_fav)
        private void onClickFavorite() {
            if (favorite) {
                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
                favorite = false;
            } else {
                iv_rest_fav.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                favorite = true;
            }
        }

        @Click(R.id.ll_category)
        private void onClick() {

            mContext.startActivity(new Intent(mContext, ViewProductsActivity.class));
        }
    }
}
