package com.huangshan.demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huangshan.demo.R;

public class L5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5);
    }

    public void enterNext(View view) {
        // 1. 构建一个意图
        Intent intent = new Intent();
        // 2. 给意图指定跳转页
        intent.setClass(this, L5bActivity.class);
        // 3. 将需要传输的数据放入 intent
        intent.putExtra("diaoInteger", 666);
        intent.putExtra("diaoString", "龙");
        // 4. 执行跳转
        startActivity(intent);
    }
}
