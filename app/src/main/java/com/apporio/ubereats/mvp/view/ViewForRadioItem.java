package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.SelectorDatum;
import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by lenovo on 4/25/2018.
 */

@Layout(R.layout.item_for_radio_dish)
public class ViewForRadioItem {

    SelectorDatum selectorDatum;
    Context context;
    int position;

    @View(R.id.tv_item_price)
    TextView tv_item_price;

    @View(R.id.tv_item_text)
    TextView tv_item_text;

    @View(R.id.radio)
    RadioButton radioButton;
    boolean checked = true;
    PlaceHolderView placeHolderView;


    public ViewForRadioItem(Context context, SelectorDatum selectorDatum, int position, PlaceHolderView placeHolderView) {
        this.context = context;
        this.selectorDatum = selectorDatum;
        this.position = position;
        this.placeHolderView = placeHolderView;
    }

    @Resolve
    private void onResolved() {

        if (!selectorDatum.getProductPrice().equals("")) {
            tv_item_price.setText("$" + " " + selectorDatum.getProductPrice().toString());
        }
        tv_item_text.setText(selectorDatum.getProductName().toString());
    }

    @Click(R.id.radio)
    public void onClick() {

        String radio_id = selectorDatum.getProductId().toString();
        placeHolderView.refresh();
        placeHolderView.refreshView(position);
        placeHolderView.getAdapter().notifyDataSetChanged();
        if (checked == true) {
            radioButton.setChecked(true);
            checked = false;

        } else {
            radioButton.setChecked(false);
            checked = true;

        }
    }

}
