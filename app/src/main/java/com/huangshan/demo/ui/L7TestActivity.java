package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.HearthstoneItem;

public class L7TestActivity extends AppCompatActivity {

    private TextView mTvRem;
    private ImageView mIvItem1;
    private ImageView mIvItem2;
    private Button mBtnBuy1;
    private Button mBtnBuy2;
    private TextView mTvInfo;

    private int mMoneyRem;
    private HearthstoneItem mItem1;
    private HearthstoneItem mItem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7_test);

        // 1. 初始化所有控件，封装在一个方法中
        initViews();
        // 2. 展示界面所有数据
        initData();
    }

    private void initData() {
        // 1. 展示初始剩余金额
        mMoneyRem = 1000;
        updateRemMoney(mMoneyRem);
        mTvInfo.setText("");

        // 2. 构建两个装备对象
        mItem1 = new HearthstoneItem();
        mItem1.name = "百变泽鲁斯";
        mItem1.cost = 300;
        mItem1.imageId = R.mipmap.image_first;

        mItem2 = new HearthstoneItem();
        mItem2.name = "着魔村民";
        mItem2.cost = 250;
        mItem2.imageId = R.mipmap.image_second;

        // 3. 展示装备相关控件内容
        mIvItem1.setImageResource(mItem1.imageId);
        mIvItem2.setImageResource(mItem2.imageId);
        mBtnBuy1.setText("$" + mItem1.cost);
        mBtnBuy2.setText("$" + mItem2.cost);
    }

    private void initViews() {
        mTvRem = (TextView) findViewById(R.id.l7_test_tv_rem);
        mIvItem1 = (ImageView) findViewById(R.id.l7_test_iv_item1);
        mIvItem2 = (ImageView) findViewById(R.id.l7_test_iv_item2);
        mBtnBuy1 = (Button) findViewById(R.id.l7_test_btn_buy1);
        mBtnBuy2 = (Button) findViewById(R.id.l7_test_btn_buy2);
        mTvInfo = (TextView) findViewById(R.id.l7_test_tv_info);
    }

    private void updateRemMoney(int newMoney) {
        mTvRem.setText("剩余金额：$" + newMoney);
    }

    public void onClickBuy1(View view) {
        // 1. 比较剩余金额和装备价格
        int diff = mMoneyRem - mItem1.cost;
        if (diff >= 0) {
            // 如果买得起，更新剩余金额，更新提示信息
            mMoneyRem = diff;
            updateRemMoney(mMoneyRem);
            mTvInfo.setText("你购买了" + mItem1.name + "，花费了$" + mItem1.cost);
        } else {
            // 如果买不起，更新提示信息
            diff = diff * -1;
            mTvInfo.setText("你买不起" + mItem1.name + "，还差$" + diff);
        }
    }

    public void onClickBuy2(View view) {
        int diff = mMoneyRem - mItem2.cost;
        if (diff >= 0) {
            mMoneyRem = diff;
            updateRemMoney(mMoneyRem);
            mTvInfo.setText("你购买了" + mItem2.name + "，花费了$" + mItem2.cost);
        } else {
            diff = diff * -1;
            mTvInfo.setText("你买不起" + mItem2.name + "，还差$" + diff);
        }
    }
}
