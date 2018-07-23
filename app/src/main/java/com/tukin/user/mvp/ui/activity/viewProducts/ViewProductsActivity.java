package com.tukin.user.mvp.ui.activity.viewProducts;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.data.network.model.productResponse.ViewProductResponse;
import com.tukin.user.mvp.ui.base.BaseActivity;
import com.tukin.user.mvp.ui.fragments.ShowProductsFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewProductsActivity extends BaseActivity implements ViewProductsMvpView {

    @Inject
    ViewProductsMvpPresenter<ViewProductsMvpView> mPresenter;

    ViewPager viewPager;
    TabLayout tabLayout;
    @BindView(R.id.iv_rest_image)
    ImageView iv_rest_image;
    MenuItem action_done;
    String category_id;

    private static final String TAG = ViewProductsActivity.class.getSimpleName();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ViewProductsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        bindActivity();
    }

    private void bindActivity() {
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        category_id = getIntent().getStringExtra("category_id");
        final Toolbar toolbar = (Toolbar) findViewById(R.id.htab_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimary);
                    collapsingToolbarLayout.setContentScrimColor(vibrantColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                }
            });

        } catch (Exception e) {
            // if Bitmap fetch fails, fallback to primary colors
            Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace());
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(this, R.color.colorPrimary)
            );
        }

        viewPager = (ViewPager) findViewById(R.id.htab_viewpager);
        mPresenter.onAttach(ViewProductsActivity.this);
        mPresenter.callApiForViewAllProducts(category_id);

    }

    @Override
    protected void setUp() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

      //  Toast.makeText(this, "is ut woirking", Toast.LENGTH_SHORT).show();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        action_done = menu.findItem(R.id.menu_fav);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                return true;

            case R.id.menu_fav:
               // Toast.makeText(this, "is ut woirking", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // getAllProductsResponse

    @Override
    public void viewAllRestauranentProducts(ViewProductResponse allProductsResponse) {

//        Log.e("AllProductsRespon", "" + allProductsResponse.getResponse().getCategories());

        if (allProductsResponse.getResponse().getFavourite()) {
            action_done.setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        } else {
            action_done.setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }


        Glide.with(this).load(ApiEndPoint.ENDPOINT_FOR_IMAGE + allProductsResponse.getResponse().getRestauranentImage().toString()).into(iv_rest_image);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(allProductsResponse.getResponse().getRestauranentName().toString());
//        if(!allProductsResponse.getResponse().getRestauranent_image().equals("")){
//            Glide.with(this).load("" + allProductsResponse.getResponse().getRestauranent_image().toString()).into(iv_rest_image);
//        }

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), allProductsResponse));

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    // ProductsAdapter
    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        ViewProductResponse allProductsResponse;

        public ViewPagerAdapter(FragmentManager manager, ViewProductResponse allProductsResponse) {
            super(manager);
            this.allProductsResponse = allProductsResponse;
        }

        @Override
        public Fragment getItem(int position) {
            return ShowProductsFragment.newInstance(allProductsResponse.getResponse(), position,allProductsResponse.getResponse().getRestauranentId());
        }

        @Override
        public int getCount() {
            return allProductsResponse.getResponse().getCategories().size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return allProductsResponse.getResponse().getCategories().get(position).getSubCategoryName();
        }
    }
}


