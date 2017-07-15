package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangshan.demo.R;

public class L41FragmentActivity extends AppCompatActivity {

    Fragment mFragmentRed = new L41FragmentRed();
    Fragment mFragmentBlue = new L41FragmentBlue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l41_fragment);
    }

    public void changeTab(View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.l41_btn_1:
                fragment = mFragmentRed;
                break;
            case R.id.l41_btn_2:
                fragment = mFragmentBlue;
                break;
        }

        if (fragment != null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.l41_fl_container, fragment);
            transaction.commit();
        }
    }

}
