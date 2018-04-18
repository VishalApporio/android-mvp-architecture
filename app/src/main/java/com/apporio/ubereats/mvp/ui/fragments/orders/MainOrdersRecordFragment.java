package com.apporio.ubereats.mvp.ui.fragments.orders;


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

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.di.component.ActivityComponent;
import com.apporio.ubereats.mvp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainOrdersRecordFragment extends BaseFragment {


    @BindView(R.id.tv_toolbar_text)
    TextView tv_toolbar_text;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;

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
        }

        return  view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tv_toolbar_text = (TextView) view.findViewById(R.id.tv_toolbar_text);
        ll_back = (LinearLayout) view.findViewById(R.id.ll_back);
        ll_back.setVisibility(View.GONE);

        tv_toolbar_text.setText("Orders");

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new HistoryFragment(), "History");
        adapter.addFragment(new HistoryFragment(), "Upcoming");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.isSmoothScrollingEnabled();

    }

    @Override
    protected void setUp(View view) {

    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
