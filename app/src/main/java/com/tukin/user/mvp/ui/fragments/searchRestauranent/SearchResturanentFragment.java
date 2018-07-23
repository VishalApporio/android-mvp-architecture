package com.tukin.user.mvp.ui.fragments.searchRestauranent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tukin.user.R;
import com.tukin.user.mvp.di.component.ActivityComponent;
import com.tukin.user.mvp.ui.base.BaseFragment;
import com.tukin.user.mvp.view.HolderSearchRestauranent;
import com.mindorks.placeholderview.PlaceHolderView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchResturanentFragment extends BaseFragment {

    @BindView(R.id.tv_toolbar_text)
    TextView tv_toolbar_text;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    @BindView(R.id.placeHolderView)
    PlaceHolderView placeHolderView;

    public SearchResturanentFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        Fragment frag = new SearchResturanentFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_search_resturanent, container, false);
        View view = inflater.inflate(R.layout.fragment_search_resturanent, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
        }

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ll_back.setVisibility(View.GONE);
        tv_toolbar_text.setText("Search Restaurants");

        for (int i = 0; i < 5; i++) {

            placeHolderView.addView(new HolderSearchRestauranent(getContext()));
        }
    }

    @Override
    protected void setUp(View view) {

    }

}
