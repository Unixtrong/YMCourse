package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.huangshan.demo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class L19ArrayListActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] mOldHeroNames;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> mHeroNameList;
    private ArrayList<String> mDcHeroNameList;
    private boolean mFirstClick = true;
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l19_array_list);
        initView();
        initData();
    }

    private void initData() {
        String nameStr = "超人 蝙蝠侠 海王 神奇女侠 钢骨";
        mOldHeroNames = nameStr.split(" ");
        // 数组通过国 length 获取长度，ArrayList 通过 size() 获取大小
        // mOldHeroNames.length;
        mDcHeroNameList = new ArrayList<>();
        for (int i = 0; i < mOldHeroNames.length; i++) {
            mDcHeroNameList.add(mOldHeroNames[i]);
        }

        mHeroNameList = new ArrayList<>();
        mHeroNameList.add("黑寡妇");
        mHeroNameList.add("浩克");
        mHeroNameList.add("钢铁侠");
        mHeroNameList.add("雷神");
        mHeroNameList.add("美国队长");
        mHeroNameList.remove(2);
        // 数据通过[]获取每一项
        // mOldHeroNames[0];
        String firstHeroName = mHeroNameList.get(0);
        Toast.makeText(this, firstHeroName, Toast.LENGTH_SHORT).show();
        mHeroNameList.set(0, "快银");

        mAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, mHeroNameList);

        mListView.setAdapter(mAdapter);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l19_lv_dynamic_array);
    }

    public void addHero(View v) {
        // mOldHeroNames[0] = "奇异博士啦啦啦啦啦啦";
        if (mFirstClick) {
            // 第一次点击时执行这些
            mHeroNameList.add("金刚狼");
            mHeroNameList.add(0, "X教授");
            mFirstClick = false;
        } else if (!mDcHeroNameList.isEmpty()) {
            int index = mRandom.nextInt(mDcHeroNameList.size());
            String name = mDcHeroNameList.get(index);
            mHeroNameList.add(0, name);
            mDcHeroNameList.remove(index);
        } else {
            Toast.makeText(this, "DC亡了", Toast.LENGTH_SHORT).show();
        }
        mAdapter.notifyDataSetChanged();
    }
}
