package com.apporio.ubereats.mvp.view;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.adapters.PromotionalAdapter;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by lenovo on 4/11/2018.
 */


@Layout(R.layout.promotions_view_layout)
public class PromotionsViewClass {

    @View(R.id.pager)
    ViewPager mPager;

    @View(R.id.indicator)
    CircleIndicator indicator;

    Context mContext;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    public PromotionsViewClass(Context context) {
        mContext = context;
    }

    @Resolve
    public void onReolved() {

        init();
    }

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager.setAdapter(new PromotionalAdapter(mContext, XMENArray));
        indicator.setViewPager(mPager);

//        // Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == XMEN.length) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 5000, 2500);
    }
}
