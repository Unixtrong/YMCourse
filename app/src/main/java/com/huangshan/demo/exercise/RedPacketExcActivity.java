package com.huangshan.demo.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.huangshan.demo.R;

public class RedPacketExcActivity extends AppCompatActivity {

    private EditText mEditMoney;
    private EditText mEditCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet_exc);
        initView();
    }

    private void initView() {
        mEditMoney = (EditText) findViewById(R.id.red_et_money);
        mEditCount = (EditText) findViewById(R.id.red_et_count);
    }

    public void senPacket(View view) {
        Editable moneyEditable = mEditMoney.getText();
        String moneyStr = moneyEditable.toString();
        if (moneyStr.length() == 0) {
            Toast.makeText(this, "必须输入金额", Toast.LENGTH_SHORT).show();
            return;
        }
        Editable countEditable = mEditCount.getText();
        String countStr = countEditable.toString();
        if (countStr.length() == 0) {
            Toast.makeText(this, "必须输入人数", Toast.LENGTH_SHORT).show();
            return;
        }

        int money = Integer.parseInt(moneyStr);
        int count = Integer.parseInt(countStr);
        if (count == 0) {
            Toast.makeText(this, "不能分给 0 个人", Toast.LENGTH_SHORT).show();
            return;
        }

        if (money < count) {
            Toast.makeText(this, "每人必须分到 1 块钱", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.setClass(this, RedPacketExcReceiveActivity.class);
        intent.putExtra("money", money);
        intent.putExtra("count", count);
        startActivity(intent);

    }
}
