package com.apporio.ubereats.mvp.ui.fragments.homefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.di.component.ActivityComponent;
import com.apporio.ubereats.mvp.ui.base.BaseFragment;
import com.apporio.ubereats.mvp.view.BottomSheetFragment;
import com.apporio.ubereats.mvp.view.HomeHorizontalCategory;
import com.apporio.ubereats.mvp.view.MoreResturanentView;
import com.apporio.ubereats.mvp.view.PromotionsViewClass;
import com.mindorks.placeholderview.PlaceHolderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";

    @BindView(R.id.rl_open_panel)
    RelativeLayout rl_open_panel;
    @BindView(R.id.ll_delivery_location)
    LinearLayout ll_delivery_location;
    @BindView(R.id.place_holder)
    PlaceHolderView place_holder;
    @BindView(R.id.activity_main_swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    public static Fragment newInstance(String text, int color) {
        Fragment frag = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_COLOR, color);
        frag.setArguments(args);
        return frag;
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
        }
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange), getResources().getColor(R.color.green), getResources().getColor(R.color.blue));


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


            }
        });

        place_holder.addView(new PromotionsViewClass(getContext()));

        for (int i = 0; i < 3; i++) {
            place_holder.addView(new HomeHorizontalCategory(getContext()));

        }

        for (int i = 0; i < 5; i++) {
            place_holder.addView(new MoreResturanentView());

        }


        return  view;
    }

    @OnClick(R.id.ll_delivery_location)
    public void openDeliveryLocationActivity(){

        //startActivity(new Intent(getActivity(), DeliveryLocationActivity.class));

    }

    @OnClick(R.id.rl_open_panel)
    public void openBottomSheet(){
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }

    @Override
    protected void setUp(View view) {

    }
}
