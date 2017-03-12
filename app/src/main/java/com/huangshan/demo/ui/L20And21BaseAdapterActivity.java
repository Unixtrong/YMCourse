package com.huangshan.demo.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.AttackSpellCardL18;
import com.huangshan.demo.bean.CardL18;
import com.huangshan.demo.bean.EffectSpellCardL18;
import com.huangshan.demo.bean.MinionCard;
import com.huangshan.demo.bean.MinionCardL18;
import com.huangshan.demo.bean.Monster;
import com.huangshan.demo.bean.SpellCardL18;
import com.huangshan.demo.ui.adapter.CardAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class L20And21BaseAdapterActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, Monster, AdapterView.OnItemLongClickListener {

    private ListView mListView;
    private ArrayList<CardL18> mData = new ArrayList<>();
    private CardAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l20_base_adapter);

        // 1. BaseAdapter ✔️
        // 2. ListView 点击事件 ✔️
        // 3. ListView 项目标签（非特殊控件）

        initView();
        initData();
    }

    private void initData() {
        // 准备数据
        mData.add(new MinionCardL18("老瞎眼", 5, 4, 5));
        mData.add(new MinionCardL18("烈焰小鬼", 1, 3, 2));
        mData.add(new MinionCardL18("虚空行者", 1, 1, 3));
        mData.add(new MinionCardL18("着魔村民", 1, 1, 1));
        mData.add(new MinionCardL18("范达尔鹿盔", 4, 5, 3));
        mData.add(new MinionCardL18("格罗玛什·地狱咆哮", 10, 10, 10));
        mData.add(new EffectSpellCardL18("弃暗投明", 2));
        mData.add(new AttackSpellCardL18("炎爆术", 10, 10));
        sort();

        // 创建自己定义的 CardAdapter
        mCardAdapter = new CardAdapter(this, mData);
        mListView.setAdapter(mCardAdapter);
    }

    private void sort() {
        ArrayList<CardL18> cards = new ArrayList<>();
        Class[] classes = new Class[3];
        classes[0] = AttackSpellCardL18.class;
        classes[1] = MinionCardL18.class;
        classes[2] = EffectSpellCardL18.class;
        for (int i = 0; i < classes.length; i++) {
            Iterator<CardL18> iterator = mData.iterator();
            while (iterator.hasNext()) {
                CardL18 card = iterator.next();
                if (classes[i] == MinionCardL18.class && card instanceof MinionCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (classes[i] == AttackSpellCardL18.class && card instanceof AttackSpellCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
                if (classes[i] == EffectSpellCardL18.class && card instanceof EffectSpellCardL18) {
                    cards.add(card);
                    iterator.remove();
                }
            }
        }
        mData = cards;
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l20_lv);
//        接口的三种实现
//        1. 建一个接口的实现类
//        mListView.setOnItemClickListener(new OnCardClickListener());
//        2. 实现一个接口的匿名内部类
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
//                String content = card.getName();
//                Toast.makeText(L20And21BaseAdapterActivity.this, content, Toast.LENGTH_SHORT).show();
//            }
//        });
//        3. 让当前类直接实现接口
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);

        // 假如有以下判断，都满足
        if (this instanceof AdapterView.OnItemClickListener) {
        }
        if (this instanceof Monster) {
        }
        if (this instanceof AppCompatActivity) {
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
        String content = card.getName();
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void eat() {
    }

    @Override
    public int killPeople() {
        return 0;
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapterView, View view, final int position, long id) {
        CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(card.getName());
        String[] items = "添加到收藏 删除".split(" ");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(L20And21BaseAdapterActivity.this, "已添加", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // 内部类可以获取外部类的成员
                        // 如果获取外部的本地变量，那么外部变量需要添加 final 关键字
                        mData.remove(position);
                        mCardAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return false;
    }

    private class OnCardClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//            String name = (String) adapterView.getItemAtPosition(position);
//            String content = name + " - " + position;
            CardL18 card = (CardL18) adapterView.getItemAtPosition(position);
            String content = card.getName();
            Toast.makeText(L20And21BaseAdapterActivity.this, content, Toast.LENGTH_SHORT).show();
        }
    }
}
