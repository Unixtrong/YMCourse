package com.huangshan.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

public class L35LifecycleActivity extends AppCompatActivity {

    public L35LifecycleActivity() {
//        Tools.debug("实例化：" + this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycle("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l35_lifecycle);
//        Tools.debug("我的内存地址：" + this);
    }

    @Override
    protected void onRestart() {
        lifecycle("onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        lifecycle("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        lifecycle("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        lifecycle("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        lifecycle("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        lifecycle("onDestroy");
        super.onDestroy();
    }

    private void lifecycle(String msg) {
        Tools.debug("L35 -> " + msg);
    }

    public void enterActivity1(View view) {
        Intent intent = new Intent(this, L35LifecycleActivity.class);
        startActivity(intent);
    }

    public void enterActivity2(View view) {
        startActivity(new Intent(this, L35Lifecycle2Activity.class));
    }
}
