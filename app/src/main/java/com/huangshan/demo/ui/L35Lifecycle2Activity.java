package com.huangshan.demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huangshan.demo.R;

public class L35Lifecycle2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l35_lifecycle2);
    }

    public void enterActivity1(View view) {
        Intent intent = new Intent(this, L35LifecycleActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void enterActivity2(View view) {
        startActivity(new Intent(this, L35Lifecycle2Activity.class));
    }
}
