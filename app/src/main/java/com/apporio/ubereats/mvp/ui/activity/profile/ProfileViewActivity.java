package com.apporio.ubereats.mvp.ui.activity.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.ui.activity.profile.changenumber.ChangeNumberActivity;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileViewActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener, ProfileMvpView {

    @Inject
    ProfileMvpPresenter<ProfileMvpView> mPresenter;

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.main_textview_title)
    TextView mTitle;

    @BindView(R.id.main_linearlayout_title)
    LinearLayout mTitleContainer;

    @BindView(R.id.main_appbar)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.iv_profile_pic)
    CircleImageView iv_profile_pic;

    @BindView(R.id.et_first_name)
    TextInputEditText et_first_name;

    @BindView(R.id.et_last_name)
    TextInputEditText et_last_name;

    @BindView(R.id.et_email)
    TextInputEditText et_email;

    @BindView(R.id.et_phone_no)
    TextInputEditText et_phone_no;

    @BindView(R.id.et_password)
    TextInputEditText et_password;

    String str_user_image;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ProfileViewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);

        bindActivity();
    }

    @Override
    protected void setUp() {

        setUnBinder(ButterKnife.bind(this));

        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_profile);

        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        et_first_name.setEnabled(false);
        et_last_name.setEnabled(false);
        et_email.setEnabled(false);
        et_phone_no.setEnabled(false);
        et_password.setEnabled(false);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void bindActivity() {
        setSupportActionBar(mToolbar);
        getActivityComponent().inject(this);
        mPresenter.onAttach(ProfileViewActivity.this);
        mPresenter.onViewProfileDetails();
    }

    @OnClick(R.id.btn_server_submit)
    void onServerSubmitClick() {

        mPresenter.onClickSubmitButton(str_user_image,
                et_first_name.getText().toString(),
                et_last_name.getText().toString(),
                et_email.getText().toString(),
                et_phone_no.getText().toString());
    }

    @Override
    public void updateUserProfileDetails(String first_name, String last_name, String email, String phone_no, String user_image) {
        setContentView(R.layout.activity_new_profile);

        setUp();
        et_first_name.setText(first_name);
        et_last_name.setText(last_name);
        et_email.setText(email);
        et_phone_no.setText(phone_no);

        str_user_image = user_image;

        Glide.with(this)
                .load(user_image)
                .asBitmap()
                .centerCrop()
                .into(iv_profile_pic);

    }

    @Override
    public void openChangePhoneNumberActivity() {
        startActivity(new Intent(this, ChangeNumberActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.menu_edit:

                Log.e("Click Me", "Click me");
                et_first_name.setEnabled(true);
                et_last_name.setEnabled(true);
                et_email.setEnabled(true);
                et_phone_no.setEnabled(true);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

}
