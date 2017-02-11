package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.huangshan.demo.R;

public class L4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l4);
    }

    public void getEditTextName(View view) {
        // 1. 获取输入框
        EditText editText = (EditText) findViewById(R.id.l4_et_name);
        // 2. 获取输入框内的文本
        Editable editable = editText.getText();
        String name = editable.toString();
        // 3. 加工得到的文本
        name = "今夜最屌の人\n" + name;
        // 4. 将该文本弹出显示
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }

    public void changeStringToNumber(View view) {
        EditText editText = (EditText) findViewById(R.id.l4_et_number);
        Editable editable = editText.getText();
        String numberText = editable.toString();
        // 将字符串转换为整型
        int number = Integer.parseInt(numberText);
        int result = number * 2;
        Toast.makeText(this, "它的两倍是：" + result, Toast.LENGTH_LONG).show();
    }
}
