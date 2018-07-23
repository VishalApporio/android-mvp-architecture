

package com.tukin.user.mvp.ui.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tukin.user.R;
import com.tukin.user.mvp.ui.activity.home.HomeActivity;
import com.tukin.user.mvp.ui.base.BaseActivity;
import com.tukin.user.mvp.ui.activity.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by vishal@apporio.com on 05/03/18.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    @BindView(R.id.tv_toolbar)
    AppCompatTextView tv_toolbar;


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
        finish();
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.enter_pickup);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_toolbar.setText("Login in");

    }
}
