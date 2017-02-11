package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.CardL8;

public class L8MethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8_method);

        CardL8 cardA = new CardL8();
        cardA.setName("百变泽鲁斯");
        String name = cardA.getName();

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }
}
