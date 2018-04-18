package com.apporio.ubereats.mvp.ui.activity.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.apporio.ubereats.mvp.ui.fragments.homefragment.HomeFragment;
import com.apporio.ubereats.mvp.ui.fragments.orders.MainOrdersRecordFragment;
import com.apporio.ubereats.mvp.ui.fragments.searchRestauranent.SearchResturanentFragment;
import com.apporio.ubereats.mvp.ui.fragments.settings.SettingsMenuFragment;
import com.apporio.ubereats.mvp.ui.main.MainActivity;

import java.lang.reflect.Field;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeMvpView {

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;

    @BindView(R.id.navigation)
    BottomNavigationView mBottomNav;

    private static final String SELECTED_ITEM = "arg_selected_item";
    private int mSelectedItem;
    private Fragment frag;
    private FragmentManager fragmentManager;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(HomeActivity.this);

        fragmentManager = getSupportFragmentManager();

        onBottomNavigationMethod(savedInstanceState);
    }

    private void onBottomNavigationMethod(Bundle savedInstanceState) {

        BottomNavigationViewHelper.disableShiftMode(mBottomNav);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                selectFragmentAgain(item);
                return true;
            }


        });


        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragmentAgain(selectedItem);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putInt(SELECTED_ITEM, mSelectedItem);
//        super.onSaveInstanceState(outState);
//    }

//    @Override
//    public void onBackPressed() {
//        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
//        if (mSelectedItem != homeItem.getItemId()) {
//            // select home item
//            selectFragment(homeItem);
//        } else {
//            super.onBackPressed();
//
//        }
//    }

    private void selectFragmentAgain(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_home:
                frag = HomeFragment.newInstance(getString(R.string.text_home),
                        getColorFromRes(R.color.color_home));
                break;
            case R.id.menu_search:
                frag = SearchResturanentFragment.newInstance();

                break;
            case R.id.menu_order:
                frag = MainOrdersRecordFragment.newInstance();

                break;
            case R.id.menu_notifications:
                frag = SettingsMenuFragment.newInstance();
                break;
            default:
                frag = HomeFragment.newInstance(getString(R.string.text_home),
                        getColorFromRes(R.color.color_home));
                break;

        }
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, frag).commit();

    }

//    private void updateToolbarText(CharSequence text) {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setTitle(text);
//        }
//    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);

    }

    public void onSortingLayoutClick(View v) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null && fragment.isVisible()) {
//            if (fragment instanceof HomeFragment) {
//                ((HomeFragment) fragment).onClick(v);
//            }
        }
    }

    public static class BottomNavigationViewHelper {
        @SuppressLint("RestrictedApi")
        public static void disableShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //noinspection RestrictedApi
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    //noinspection RestrictedApi
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e);
            }
        }
    }

    @Override
    protected void setUp() {


    }
}
