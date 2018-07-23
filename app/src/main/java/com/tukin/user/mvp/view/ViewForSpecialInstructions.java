package com.tukin.user.mvp.view;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.DaoSession;
import com.tukin.user.mvp.data.db.model.ProductDatadb;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

/**
 * Created by lenovo on 4/26/2018.
 */

@Layout(R.layout.view_for_special_instructions)
public class ViewForSpecialInstructions {

    @View(R.id.ll_minus)
    LinearLayout ll_minus;
    @View(R.id.ll_plus)
    LinearLayout ll_plus;
    @View(R.id.tv_no_of_items)
    TextView tv_no_of_items;

    int i = 1;

    DaoSession mDaoSession;
    PlaceHolderView placeHolderView;
    Context context;
    List<ProductDatadb> productDatadbList;
    OncategorySelected mListener;


    public ViewForSpecialInstructions(Context context, PlaceHolderView placeHolderView, OncategorySelected listener) {
        this.context = context;
        this.placeHolderView = placeHolderView;
        mListener = listener;
    }

    @Resolve
    private void onResolved() {

        Log.e("quantityValue", "" + i);
        // productDatadb.setProduct_quantity(i);

    }


    @Click(R.id.ll_plus)
    public void onClickPlus() {
        i++;
        Log.e("ClickIt", " " + i);
        //placeHolderView.refresh();

        // tv_quantity_text.setText(productDatadb.getProduct_quantity());

        tv_no_of_items.setText(String.valueOf(i));
        mListener.onAddSelected(i);

    }

    @Click(R.id.ll_minus)
    public void onClickMinus() {

        if (i != 1) {
            i--;
        }
        tv_no_of_items.setText(String.valueOf(i));
        mListener.onAddSelected(i);

    }

    public interface OncategorySelected {

        public void onAddSelected(int category_id);

    }


}

