package com.tukin.user.mvp.ui.activity.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tukin.user.R;
import com.tukin.user.mvp.ui.activity.home.HomeActivity;
import com.tukin.user.mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @Inject
    RegisterMvpPresenter<RegisterMvpView> mPresenter;

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.et_first_name)
    EditText mFirstNameEditText;

    @BindView(R.id.et_last_name)
    EditText mLastNameEditText;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_phone_no)
    EditText mPhoneEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;


    @BindView(R.id.tv_toolbar)
    AppCompatTextView tv_toolbar;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(RegisterActivity.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.enter_pickup);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_toolbar.setText("Register");

        setColorTxtMethod();
    }

    @OnClick(R.id.btn_server_submit)
    void onServerRegister(View v) {

        mPresenter.onServerRegister(mFirstNameEditText.getText().toString(),
                mLastNameEditText.getText().toString(),
                mEmailEditText.getText().toString(),
                mPhoneEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }

    private void setColorTxtMethod() {

        String drive_a = getColoredSpanned("By clicking" + " " + "REGISTER," + " I confirm that I have read and agreed to the", "#8F8F8F");
        String better = getColoredSpanned("Terms & Conditions", "#1FBAD6");
        String city = getColoredSpanned("and", "#8F8F8F");
        String city1 = getColoredSpanned("Privacy Policy.", "#1FBAD6");
        textView.setText(Html.fromHtml(drive_a + " " + better + " " + city + " " + city1));
    }


    private String getColoredSpanned(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openMainActivity() {
        Intent intent = HomeActivity.getStartIntent(RegisterActivity.this);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
