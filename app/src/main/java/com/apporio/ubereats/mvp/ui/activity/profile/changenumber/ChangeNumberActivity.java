package com.apporio.ubereats.mvp.ui.activity.profile.changenumber;

import android.os.Bundle;
import android.widget.TextView;

import com.apporio.ubereats.R;
import com.apporio.ubereats.mvp.ui.base.BaseActivity;

public class ChangeNumberActivity extends BaseActivity {

    TextView tv_toolbar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_number);

        setUp();
    }

    @Override
    protected void setUp() {
        tv_toolbar_text = (TextView) findViewById(R.id.tv_toolbar_text);
        tv_toolbar_text.setText("");

    }
}
