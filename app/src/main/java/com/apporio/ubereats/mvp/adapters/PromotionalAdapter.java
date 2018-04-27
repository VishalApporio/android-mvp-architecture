package com.apporio.ubereats.mvp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.bumptech.glide.Glide;

/**
 * Created by lenovo on 4/11/2018.
 */

public class PromotionalAdapter extends PagerAdapter {

    //    private ArrayList<Integer> images;
    ViewResturanentsModel mpromotional_data;
    private LayoutInflater inflater;
    private Context context;

//    public PromotionalAdapter(Context context, ArrayList<Integer> images) {
//        this.context = context;
//        this.images = images;
//        inflater = LayoutInflater.from(context);
//    }

    public PromotionalAdapter(Context mContext, ViewResturanentsModel mpromotional_data) {
        this.context = mContext;
        this.mpromotional_data = mpromotional_data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {

        return mpromotional_data.getResponse().getPromotional_data().size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
        // myImage.setImageDrawable(mpromotional_data.get(position).getPromotional_image());

        Glide.with(context)
                .load(mpromotional_data.getResponse().getPromotional_data().get(position).getPromotional_image())
                .asBitmap()
                .centerCrop()
                .into(myImage);

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}

