package com.tukin.user.mvp.view;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;

import com.tukin.user.mvp.di.others.events.GetAllProductInformationEvent;
import com.tukin.user.mvp.di.others.events.RemoveProductInformationEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lenovo on 4/25/2018.
 */

@Layout(R.layout.items_check_for_dish)
public class ViewForCheckItem {

  //  SelectorDatum selectorDatum;
    Context context;
    int position;

    @View(R.id.tv_item_price)
    TextView tv_item_price;

    @View(R.id.tv_item_text)
    TextView tv_item_text;

    @View(R.id.radio)
    CheckBox radio;

//    public ViewForCheckItem(Context context, SelectorDatum selectorDatum, int position) {
//        this.context = context;
//        this.selectorDatum = selectorDatum;
//        this.position = position;
//    }

    @Resolve
    private void onResolved() {

//        if (!selectorDatum.getProductPrice().equals("")) {
//            tv_item_price.setText("$" + " " + selectorDatum.getProductPrice().toString());
//        }
//        tv_item_text.setText(selectorDatum.getProductName().toString());
//
//        radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    if (selectorDatum.getProductPrice().equals("")) {
//                        EventBus.getDefault().post(new GetAllProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), "0"));
//
//                    } else {
//                        EventBus.getDefault().post(new GetAllProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), selectorDatum.getProductPrice().toString()));
//
//                    }
//                } else {
//                    if (selectorDatum.getProductPrice().equals("")) {
//                        EventBus.getDefault().post(new RemoveProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), "0"));
//
//                    } else {
//                        EventBus.getDefault().post(new RemoveProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), selectorDatum.getProductPrice().toString()));
//
//                    }
//                }
//            }
//
//        });

    }
}
