package com.tukin.user.mvp.view;

import android.content.Context;

import com.tukin.user.R;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;

/**
 * Created by lenovo on 4/11/2018.
 */

@Layout(R.layout.view_search_restauranent)
public class HolderSearchRestauranent {

    Context context;

    public HolderSearchRestauranent(Context context) {
        this.context = context;
    }

    @Click(R.id.ll_view_restauranent)
    private void onClick() {

      //  context.startActivity(new Intent(context, ViewRestauranentClass.class));
    }
}
