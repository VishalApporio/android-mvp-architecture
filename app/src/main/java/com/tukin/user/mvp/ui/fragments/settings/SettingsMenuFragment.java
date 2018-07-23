package com.tukin.user.mvp.ui.fragments.settings;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tukin.user.R;
import com.tukin.user.mvp.data.network.ApiEndPoint;
import com.tukin.user.mvp.di.component.ActivityComponent;
import com.tukin.user.mvp.ui.about.AboutFragment;
import com.tukin.user.mvp.ui.activity.login.LoginActivity;
import com.tukin.user.mvp.ui.activity.profile.ProfileViewActivity;
import com.tukin.user.mvp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsMenuFragment extends BaseFragment implements SettingsMvpView {

    @BindView(R.id.ll_profile_settings)
    LinearLayout ll_profile_settings;

    @BindView(R.id.ll_logout)
    LinearLayout ll_logout;

    @BindView(R.id.iv_user_image)
    AppCompatImageView iv_user_image;

    @BindView(R.id.tv_user_name)
    TextView tv_user_name;


    @Inject
    SettingMvpPresenter<SettingsMvpView> mPresenter;


    public SettingsMenuFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        Fragment frag = new SettingsMenuFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings_menu, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mPresenter.getUserInformation();
        }
        ll_profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProfileViewActivity.class));
            }
        });

        ll_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onOptionLogoutClick();
            }
        });
        return view;
    }

    @OnClick(R.id.ll_about)
    void openAboutFragment() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
                .commit();
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(getActivity()));
        getActivity().finish();
    }

    @Override
    public void updateUserInformation(String user_image, String user_name) {

        if (!user_image.equals("")) {
            Glide.with(this)
                    .load(ApiEndPoint.ENDPOINT_FOR_IMAGE + user_image)
                    .asBitmap()
                    .centerCrop()
                    .into(iv_user_image);
        }

        tv_user_name.setText(user_name);

    }
}
