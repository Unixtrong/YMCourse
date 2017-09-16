package com.huangshan.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.kt.ui.Kt1ButtonActivity;
import com.huangshan.demo.kt.ui.Kt2TextViewActivity;

import java.util.ArrayList;
import java.util.List;

public class L1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l1);
    }

    public void clickButton(View view) {
        if (view.getId() == R.id.main_btn_1) {
            Toast.makeText(this, "you click a button 111111.", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.main_btn_2) {
            Toast.makeText(this, "you click a button 222222.", Toast.LENGTH_SHORT).show();
        }

        new Handler();

        

        LinearLayout root = (LinearLayout) findViewById(R.id.activity_home);
        List<Class<? extends Activity>> classes = new ArrayList<>();
        classes.add(Kt1ButtonActivity.class);
        classes.add(Kt2TextViewActivity.class);
        for (Class clz : classes) {
            Button button = new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            root.addView(button);
        }
    }

    final String[] textArray = new String[]{"！", "好", "法", "大", "Kotlin"};
    int[] indexArray = new int[]{7, 6, 5, 4, 3, 2, 1, 0};

    private void foo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String buffer = "";
                for (int index : indexArray) {
                    if (index < textArray.length) {
                        buffer += textArray[index];
                    }
                }
                final String result = buffer;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(result);
                    }
                });
            }
        }).start();
    }
}
