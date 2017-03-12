package com.huangshan.demo.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;

public class LongL2Activity extends AppCompatActivity {
    TextView text_nam;
    int a;
    String b = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text_nam = (TextView) findViewById(R.id.textView2);
    }

    public void changenum(View view) {
        a = a + 1;
        if (a <=9) {
            b = b+a;
            text_nam.setText(b + "");
        }
        if (a == 10) {
            a = 0;
            b = "0";
            text_nam.setText(b + "");
        }
    }

    public void clear(View view) {
        a = 0;
        b="0";
        text_nam.setText(a + "");
    }
}

