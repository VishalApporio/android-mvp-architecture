package com.tukin.user.mvp.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.model.ViewResturanentsModel;

/**
 * Created by lenovo on 5/2/2018.
 */

@Layout(R.layout.home_category_view)
public class HolderForShowAllCategories {

    @View(R.id.place_holder)
    PlaceHolderView place_holder;

    Context context;
    ViewResturanentsModel viewResturanentsModel;

    public HolderForShowAllCategories(Context context, ViewResturanentsModel viewResturanentsModel) {
        this.context = context;
        this.viewResturanentsModel = viewResturanentsModel;
    }

    @Resolve
    public void onReolved() {

        place_holder.setLayoutManager(new GridLayoutManager(context, 3));
        for (int i = 0; i < viewResturanentsModel.getResponse().getScroller_all_data().size(); i++) {
            place_holder.addView(new HolderForCategoryItem(context,viewResturanentsModel.getResponse().getScroller_all_data().get(i)));
        }

    }

}
