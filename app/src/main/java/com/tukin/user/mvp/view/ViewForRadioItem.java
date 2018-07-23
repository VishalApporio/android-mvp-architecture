package com.tukin.user.mvp.view;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.tukin.user.R;

import java.util.ArrayList;

/**
 * Created by lenovo on 4/25/2018.
 */

@Layout(R.layout.item_for_radio_dish)
public class ViewForRadioItem {

    //  SelectorDatum selectorDatum;
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
    ArrayList<Integer> refreshlist;
    ArrayList<String> selectorIdList;


//    public ViewForRadioItem(Context context, SelectorDatum selectorDatum, int position, PlaceHolderView placeHolderView, ArrayList arrayList, ArrayList<String> selectorIdList) {
//        this.context = context;
//        this.selectorDatum = selectorDatum;
//        this.position = position;
//        this.placeHolderView = placeHolderView;
//        this.refreshlist = arrayList;
//        this.selectorIdList = selectorIdList;
//    }

    @Resolve
    private void onResolved() {

//        if (!selectorDatum.getProductPrice().equals("")) {
//            tv_item_price.setText("$" + " " + selectorDatum.getProductPrice().toString());
//        }
//        tv_item_text.setText(selectorDatum.getProductName().toString());
//
//        if (refreshlist.get(position) == 1) {
//            radioButton.setChecked(true);
//        } else {
//            radioButton.setChecked(false);
////            if (selectorIdList.contains(selectorDatum.getProductId().toString())) {
////                int f;
////                f = selectorIdList.indexOf(selectorDatum.getProductId().toString());
////                selectorIdList.remove(f);
////            } else {
////            }

    }


    @Click(R.id.radio)
    public void onClick() {
//
//        for (int i = 0; i < refreshlist.size(); i++) {
//
//            if (i == position) {
//                if (refreshlist.get(position) == 1) {
//                    refreshlist.set(i, 0);
//
//                    if (selectorDatum.getProductPrice().equals("")) {
//                        EventBus.getDefault().post(new RemoveProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), "0"));
//
//                    } else {
//                        EventBus.getDefault().post(new RemoveProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), selectorDatum.getProductPrice().toString()));
//
//                    }
//
//                } else {
//                    refreshlist.set(i, 1);
//                    if (selectorDatum.getProductPrice().equals("")) {
//                        EventBus.getDefault().post(new GetAllProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), "0"));
//
//                    } else {
//                        EventBus.getDefault().post(new GetAllProductInformationEvent(selectorDatum.getProductId(), selectorDatum.getProductName().toString(), selectorDatum.getProductAvailability().toString(), selectorDatum.getProductPrice().toString()));
//
//                    }
//                }
//            } else {
//                refreshlist.set(i, 0);
//
//            }
//        }
//        placeHolderView.refresh();
//        //selectorIdList.set(i, selectorDatum.getProductId().toString());
//
//
//        Log.e("RadioSelected", "" + selectorDatum.getProductName());

    }
}
