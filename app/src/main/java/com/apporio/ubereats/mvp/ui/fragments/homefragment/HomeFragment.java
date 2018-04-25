package com.apporio.ubereats.mvp.ui.fragments.homefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.data.network.model.ViewResturanentsModel;
import com.apporio.ubereats.mvp.di.component.ActivityComponent;
import com.apporio.ubereats.mvp.di.others.events.LocationSessionEvent;
import com.apporio.ubereats.mvp.location.LocationSession;
import com.apporio.ubereats.mvp.ui.activity.deliveryLocation.DeliveryLocationActivity;
import com.apporio.ubereats.mvp.ui.base.BaseFragment;
import com.apporio.ubereats.mvp.view.BottomSheetFragment;
import com.apporio.ubereats.mvp.view.HomeHorizontalCategory;
import com.apporio.ubereats.mvp.view.MoreResturanentView;
import com.apporio.ubereats.mvp.view.PromotionsViewClass;
import com.mindorks.placeholderview.PlaceHolderView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeFragmentMvpView {

    @Inject
    HomeFragmentMvpPresenter<HomeFragmentMvpView> mPresenter;

    @Inject
    LocationSession locationSession;

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
    @BindView(R.id.tv_location_address)
    TextView tv_location_address;


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
            mPresenter.onAttach(this);
            mPresenter.onViewAllRestuaranents();
        }

        view.findViewById(R.id.ll_delivery_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DeliveryLocationActivity.class));
            }
        });


        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange), getResources().getColor(R.color.green), getResources().getColor(R.color.blue));


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


            }
        });

        EventBus.getDefault().register(this);
        setAddressMethod(locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LOCATION_TEXT));

        return view;
    }

    private void setAddressMethod(String gegrophic_location) {

        if (!locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT).equals("") || !locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT).equals("null")) {

            tv_location_address.setText(gegrophic_location);

            Log.e("Latitude", "" + locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LAT));

            Log.e("Longitude", "" + locationSession.getLocationDetails().get(LocationSession.KEY_CURRENT_LONG));

        } else {
            tv_location_address.setText("Select Location");
        }
    }

    @OnClick(R.id.ll_delivery_location)
    public void openDeliveryLocationActivity() {

        //startActivity(new Intent(getActivity(), DeliveryLocationActivity.class));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LocationSessionEvent event) {

        Log.e("Vishal", "Vishal");
        setAddressMethod(event.getGeographic_location());

    }


    @OnClick(R.id.rl_open_panel)
    public void openBottomSheet() {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void updateAllRestauranentsView(ViewResturanentsModel viewResturanentsModel) {

     //   place_holder.addView(new PromotionsViewClass(getContext(),viewResturanentsModel.getResponse().getPromotional_data()));

        Log.e("Size of array", "" + viewResturanentsModel.getResponse().getScroller_all_data().size());

        for (int i = 0; i < viewResturanentsModel.getResponse().getScroller_all_data().size(); i++) {

            if (viewResturanentsModel.getResponse().getScroller_all_data().get(i).getView_scroller_mode() == 0) {
                place_holder.addView(new HomeHorizontalCategory(getContext(),viewResturanentsModel.getResponse().getScroller_all_data().get(i)));

            } else if (viewResturanentsModel.getResponse().getScroller_all_data().get(i).getView_scroller_mode() == 1) {
                place_holder.addView(new MoreResturanentView(getContext(),viewResturanentsModel.getResponse().getScroller_all_data().get(i)));
            }
        }
    }
}
