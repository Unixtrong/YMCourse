package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;

public class L2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l2);
    }

    public void changeTextView(View view) {
        TextView tvName = (TextView) findViewById(R.id.text_tv_name);
        tvName.setText("New Text");
    }
}
