package com.apporio.ubereats.mvp.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.AllProductsResponse;
import com.apporio.ubereats.mvp.view.CategoryItems;
import com.mindorks.placeholderview.PlaceHolderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowProductsFragment extends Fragment {

    int color;
    public static AllProductsResponse.ResponseBean mAllProductsResponse;
    public static int mCategoryPosition;
    AllProductsResponse.ResponseBean.CategoriesBean mData;


    public ShowProductsFragment() {
        // Required empty public constructor
    }

    public static ShowProductsFragment newInstance(AllProductsResponse.ResponseBean allProductsResponse, int category_position) {
        ShowProductsFragment f = new ShowProductsFragment();
        Bundle b = new Bundle();
        b.putInt("msg", category_position);
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

        PlaceHolderView place_holder = (PlaceHolderView) view.findViewById(R.id.place_holder);


        for (int j = 0; j < mData.getCategory_products().size(); j++) {
            place_holder.addView(new CategoryItems(getContext(), mData.getCategory_products().get(j),mCategoryPosition));

        }

//        for (int i = 0; i < 3; i++) {
//            place_holder.addView(new ViewNameCategories());
//
//
//        }

        return view;
    }
}
