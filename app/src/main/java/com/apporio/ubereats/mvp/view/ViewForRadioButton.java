package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.CategoryProduct;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by lenovo on 4/25/2018.
 */

@Layout(R.layout.category_radio_for_dish)
public class ViewForRadioButton {

    @View(R.id.place_holder)
    PlaceHolderView place_holder;
    @View(R.id.ll_required_layout)
    LinearLayout ll_required_layout;

    @View(R.id.tv_item_category)
    TextView tv_item_category;

    CategoryProduct categoryProduct;
    Context context;
    int position;

    public ViewForRadioButton(Context context, CategoryProduct categoryProduct, int position) {
        this.context = context;
        this.categoryProduct = categoryProduct;
        this.position = position;
    }

    @Resolve
    private void onResolved() {

        tv_item_category.setText(categoryProduct.getSelectors().get(position).getSelectorName().toString());

        if (categoryProduct.getSelectors().get(position).getMandatory()) {
            ll_required_layout.setVisibility(android.view.View.VISIBLE);
        } else {
            ll_required_layout.setVisibility(android.view.View.GONE);
        }
        for (int i = 0; i < categoryProduct.getSelectors().get(position).getSelectorData().size(); i++) {
            place_holder.addView(new ViewForRadioItem(context, categoryProduct.getSelectors().get(position).getSelectorData().get(i), i, place_holder));
        }
    }
}
