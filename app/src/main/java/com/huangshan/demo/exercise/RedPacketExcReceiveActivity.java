package com.huangshan.demo.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.huangshan.demo.R;

import java.util.Random;

public class RedPacketExcReceiveActivity extends AppCompatActivity {

    private int mCount;
    private int mMoney;
    private ListView mListView;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_packet_exc_receive);
        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.red_rcv_lv);
    }

    private void initData() {
        mRandom = new Random();
        Intent intent = getIntent();
        mMoney = intent.getIntExtra("money", 0);
        mCount = intent.getIntExtra("count", 0);
    }

    public void receiveRedPacket(View view) {
        if (mMoney == 0 || mCount == 0) {
            Toast.makeText(this, "没钱你发个鸡巴", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] array = new String[mCount];
        for (int remCount = mCount; remCount >= 1; remCount = remCount - 1) {
            int currentMoney;
            if (remCount == 1) {
                currentMoney = mMoney;
            } else {
                currentMoney = mRandom.nextInt(mMoney - remCount + 1) + 1;
                mMoney = mMoney - currentMoney;
            }
            array[remCount - 1] = "第" + remCount + "个人分到了 " + currentMoney + "元";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        mListView.setAdapter(adapter);
    }
}
