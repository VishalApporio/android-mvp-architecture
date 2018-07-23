package com.tukin.user.mvp.ui.fragments.orders.mainOrder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.placeholderview.PlaceHolderView;
import com.tukin.user.R;
import com.tukin.user.mvp.data.db.model.orderHistory.OrderHistoryResponse;
import com.tukin.user.mvp.di.component.ActivityComponent;
import com.tukin.user.mvp.ui.base.BaseFragment;
import com.tukin.user.mvp.ui.fragments.orders.views.viewsForActive.HolderViewForOrder;
import com.tukin.user.mvp.ui.fragments.orders.views.viewsForHistory.HolderViewForPast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainOrdersRecordFragment extends BaseFragment implements MainOrderMvpView {

    @Inject
    MainOrderMvpPresenter<MainOrderMvpView> mPresenter;

    @BindView(R.id.tv_toolbar_text)
    TextView tv_toolbar_text;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    TabLayout tabLayout;
    static OrderHistoryResponse mOrderHistoryResponse;

    public MainOrdersRecordFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        Fragment frag = new MainOrdersRecordFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_orders_record, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mPresenter.viewAllOrderResponse();
        }

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tv_toolbar_text = (TextView) view.findViewById(R.id.tv_toolbar_text);
        ll_back = (LinearLayout) view.findViewById(R.id.ll_back);
        ll_back.setVisibility(View.GONE);

        tv_toolbar_text.setText("Orders");

        viewPager = (ViewPager) view.findViewById(R.id.pager);

        // Add Fragments to adapter one by one
//        adapter.addFragment(new HistoryFragment(), "History");
//        adapter.addFragment(new HistoryFragment(), "Upcoming");
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);


    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void viewAllHistoryResponse(OrderHistoryResponse orderHistoryResponse) {

        mOrderHistoryResponse = orderHistoryResponse;

        adapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.isSmoothScrollingEnabled();
    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        String[] fragmens_name = {"Upcoming", "History"};


        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return ActiveFragment.newInstance();
            } else {
                return PastFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return fragmens_name.length;
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmens_name[position];
        }
    }


    public static class ActiveFragment extends Fragment {

        @BindView(R.id.place_holder)
        PlaceHolderView placeHolder;

        public ActiveFragment() {
        }

        public static ActiveFragment newInstance() {
            ActiveFragment fragment = new ActiveFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_upcoming, container, false);
            ButterKnife.bind(this, rootView);
            placeHolder.removeAllViews();

            try {
                for (int i = 0; i < mOrderHistoryResponse.getResponse().getOngoingOrders().size(); i++) {

                    placeHolder.addView(new HolderViewForOrder(getActivity(), placeHolder, mOrderHistoryResponse.getResponse().getOngoingOrders().get(i)));
                }
            } catch (
                    Exception e) {
            }

            return rootView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }


    public static class PastFragment extends Fragment {


        @BindView(R.id.place_holder)
        PlaceHolderView placeHolder;

        public PastFragment() {
        }

        public static PastFragment newInstance() {
            PastFragment fragment = new PastFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_history, container, false);
            ButterKnife.bind(this, rootView);

            placeHolder.removeAllViews();

            try {
                for (int i = 0; i < mOrderHistoryResponse.getResponse().getCompletedOrders().size(); i++) {

                    placeHolder.addView(new HolderViewForPast(getActivity(), placeHolder, mOrderHistoryResponse.getResponse().getCompletedOrders().get(i)));
                }
            } catch (
                    Exception e) {
            }

            return rootView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }

}
