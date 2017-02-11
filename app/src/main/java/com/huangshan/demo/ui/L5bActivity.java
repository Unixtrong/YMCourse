package com.huangshan.demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.huangshan.demo.R;

public class L5bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5b);

        // 0. 获取上一页传入的 Intent
        Intent newIntent = getIntent();
        // 1. 获取上一页传入的数据
        int dataInt = newIntent.getIntExtra("diaoInteger", 0);
        String dataStr = newIntent.getStringExtra("diaoString");
        // 2. 从布局中得到 TextView
        TextView tvData = (TextView) findViewById(R.id.l5b_tv_data);
        // 3. 将获取到的数据展示在 TextView 上
        tvData.setText("得到 diaoInteger：" + dataInt + "\n得到 diaoString：" + dataStr);
    }
}
