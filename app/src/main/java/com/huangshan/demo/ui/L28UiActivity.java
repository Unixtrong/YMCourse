package com.huangshan.demo.ui;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.huangshan.demo.R;

public class L28UiActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l28_ui);
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.l28_btn);
    }
}
