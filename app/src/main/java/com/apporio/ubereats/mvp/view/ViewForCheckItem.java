package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.allProductresponse.SelectorDatum;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import butterknife.BindView;

/**
 * Created by lenovo on 4/25/2018.
 */

@Layout(R.layout.items_check_for_dish)
public class ViewForCheckItem {

    SelectorDatum selectorDatum;
    Context context;
    int position;

    @View(R.id.tv_item_price)
    TextView tv_item_price;

    @View(R.id.tv_item_text)
    TextView tv_item_text;

    public ViewForCheckItem(Context context, SelectorDatum selectorDatum, int position) {
        this.context = context;
        this.selectorDatum = selectorDatum;
        this.position = position;
    }

    @Resolve
    private void onResolved() {

        if(!selectorDatum.getProductPrice().equals("")){
            tv_item_price.setText("$"+" "+selectorDatum.getProductPrice().toString());
        }
        tv_item_text.setText(selectorDatum.getProductName().toString());


    }


}
