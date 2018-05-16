

package com.apporio.ubereats.mvp.ui.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.ui.activity.home.HomeActivity;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;
import com.apporio.ubereats.mvp.ui.main.MainActivity;
import com.apporio.ubereats.mvp.ui.activity.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by vishal@apporio.com on 27/01/17.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    @BindView(R.id.ll_back)
    LinearLayout ll_back;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(LoginActivity.this);

        setUp();
    }


    @OnClick(R.id.btn_server_login)
    void onServerLoginClick(View v) {
        mPresenter.onServerLoginClick(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    @OnClick(R.id.btn_register)
    void onRegisterBtnClick(View v) {
        Intent intent = RegisterActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
    }

//    @OnClick(R.id.ib_google_login)
//    void onGoogleLoginClick(View v) {
//        mPresenter.onGoogleLoginClick();
//    }
//
//    @OnClick(R.id.ib_fb_login)
//    void onFbLoginClick(View v) {
//        mPresenter.onFacebookLoginClick();
//    }

    @Override
    public void openMainActivity() {
        Intent intent = HomeActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        ll_back.setVisibility(View.GONE);
    }
}
