package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;

import java.util.Random;

public class L3Activity extends AppCompatActivity {
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l3);
    }

    public void randomNumber(View view) {
        count = count + 1;
        switch (count) {
            case 1:
                changeNumber1();
                break;
            case 2:
                changeNumber2();
                break;
            case 3:
                changeNumber3();
                clearCount();
                break;
        }
    }

    public void clearCount() {
        count = 0;
    }

    public void changeNumber1() {
        int a = new Random().nextInt(100);
        TextView tvNum1 = (TextView) findViewById(R.id.l3_tv_num1);
        tvNum1.setText("变1: " + a);
    }

    public void changeNumber2() {
        int b = new Random().nextInt(100);
        TextView tvNum2 = (TextView) findViewById(R.id.l3_tv_num2);
        tvNum2.setText("变2: " + b);
    }

    public void changeNumber3() {
        int c = new Random().nextInt(100);
        TextView tvNum3 = (TextView) findViewById(R.id.l3_tv_num3);
        tvNum3.setText("变3: " + c);
    }
}
