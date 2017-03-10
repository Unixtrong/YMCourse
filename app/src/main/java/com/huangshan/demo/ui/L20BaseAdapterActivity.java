package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.AttackSpellCardL18;
import com.huangshan.demo.bean.CardL18;
import com.huangshan.demo.bean.MinionCardL18;
import com.huangshan.demo.bean.SpellCardL18;
import com.huangshan.demo.ui.adapter.CardAdapter;

import java.util.ArrayList;

public class L20BaseAdapterActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<CardL18> mData = new ArrayList<>();
    private CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l20_base_adapter);

        initView();
        initData();
    }

    private void initData() {
        // 准备数据
        MinionCardL18 cardOldBlindEyes = new MinionCardL18("老瞎眼");
        cardOldBlindEyes.setCost(5);
        cardOldBlindEyes.setDamage(4);
        MinionCardL18 cardOldBlindEyes2 = new MinionCardL18("老瞎眼2");
        cardOldBlindEyes.setCost(5);
        cardOldBlindEyes.setDamage(4);
        MinionCardL18 cardOldBlindEyes3 = new MinionCardL18("老瞎眼3");
        cardOldBlindEyes.setCost(5);
        cardOldBlindEyes.setDamage(4);
        MinionCardL18 cardOldBlindEyes4 = new MinionCardL18("老瞎眼3");
        cardOldBlindEyes.setCost(5);
        cardOldBlindEyes.setDamage(4);
        AttackSpellCardL18 cardFire = new AttackSpellCardL18("炎爆术");
        cardFire.setCost(10);
        cardFire.setDamage(10);
        MinionCardL18 cardVan = new MinionCardL18("范达尔鹿盔");
        cardVan.setCost(4);
        cardVan.setHp(5);
        cardVan.setDamage(3);
        MinionCardL18 cardGromash = new MinionCardL18("格罗玛什·地狱咆哮");
        cardGromash.setCost(10);
        cardGromash.setDamage(10);
        cardGromash.setHp(10);
        SpellCardL18 cardHxm = new SpellCardL18("弃暗投明") {
            @Override
            public void play() {
            }
        };
        cardHxm.setCost(2);

        // 添加到数据集合里
        mData.add(cardOldBlindEyes);
        mData.add(cardFire);
        mData.add(cardOldBlindEyes2);
        mData.add(cardVan);
        mData.add(cardGromash);
        mData.add(cardOldBlindEyes3);
        mData.add(cardHxm);
        mData.add(cardOldBlindEyes4);

        // 创建自己定义的 CardAdapter
        mCardAdapter = new CardAdapter(this, mData);
        mListView.setAdapter(mCardAdapter);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l20_lv);
    }
}
