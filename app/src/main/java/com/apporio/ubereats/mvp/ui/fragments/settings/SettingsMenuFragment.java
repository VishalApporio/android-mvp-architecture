package com.apporio.ubereats.mvp.ui.fragments.settings;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.di.component.ActivityComponent;
import com.apporio.ubereats.mvp.ui.activity.NewProfileActivity;
import com.apporio.ubereats.mvp.ui.activity.login.LoginActivity;
import com.apporio.ubereats.mvp.ui.activity.profile.ProfileViewActivity;
import com.apporio.ubereats.mvp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsMenuFragment extends BaseFragment implements SettingsMvpView {

    @BindView(R.id.ll_profile_settings)
    LinearLayout ll_profile_settings;

    @BindView(R.id.ll_logout)
    LinearLayout ll_logout;


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
        }
        ll_profile_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NewProfileActivity.class));
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

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(getActivity()));
        getActivity().finish();
    }
}
