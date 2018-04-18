package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.ui.activity.ViewProductsActivity;
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

    public HomeHorizontalCategory(Context context) {
        mContext = context;
    }


    @Resolve
    private void onResolved() {

        placeholder.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

        for (int i = 0; i < 10; i++) {

            placeholder.addView(new HolderCategoriesView(mContext));
        }

    }

    @Layout(R.layout.home_horizontal_view)
    public class HolderCategoriesView {

        Context mContext;

        public HolderCategoriesView(Context context) {

            mContext = context;
        }

        @Resolve
        private void onResolved() {

        }

        @Click(R.id.ll_category)
        private void onClick() {

            mContext.startActivity(new Intent(mContext, ViewProductsActivity.class));
        }
    }
}
