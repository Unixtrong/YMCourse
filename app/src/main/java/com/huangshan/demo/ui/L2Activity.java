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
        View tvView = findViewById(R.id.text_tv_name);
        if (tvView instanceof TextView) {
            TextView tvName = (TextView) tvView;
            tvName.setText("New Text");
        }
    }
}
