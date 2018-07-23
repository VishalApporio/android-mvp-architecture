package com.tukin.user.mvp.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.placeholderview.PlaceHolderView;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.model.productResponse.Category;
import com.tukin.user.mvp.data.network.model.productResponse.Response;
import com.tukin.user.mvp.view.CategoryItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowProductsFragment extends Fragment {

    int color;
    public static Response mAllProductsResponse;
    public static int mCategoryPosition;
    Category mData;

    static String mcategory_id;

    public ShowProductsFragment() {
        // Required empty public constructor
    }

    public static ShowProductsFragment newInstance(Response allProductsResponse, int category_position,String category_id) {
        ShowProductsFragment f = new ShowProductsFragment();
        Bundle b = new Bundle();
        b.putInt("msg", category_position);
        mcategory_id = category_id;
        mAllProductsResponse = allProductsResponse;
        mCategoryPosition = category_position;
        f.setArguments(b);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        mData = mAllProductsResponse.getCategories().get(getArguments().getInt("msg"));

        Log.e("Data", "" + mData);

        PlaceHolderView place_holder = (PlaceHolderView) view.findViewById(R.id.place_holder);

        Log.e("Category_id",mcategory_id);

        for (int j = 0; j < mData.getCategoryProducts().size(); j++) {
            place_holder.addView(new CategoryItems(getContext(), mData.getCategoryProducts().get(j), mCategoryPosition,mcategory_id,mData.getCategoryId()));

        }

//        for (int i = 0; i < 3; i++) {
//            place_holder.addView(new ViewNameCategories());
//
//
//        }

        return view;
    }
}
