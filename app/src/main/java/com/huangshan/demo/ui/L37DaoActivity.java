package com.huangshan.demo.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.HeroBean;
import com.huangshan.demo.consts.TableHero;
import com.huangshan.demo.dao.DaoHelper;
import com.huangshan.demo.ui.adapter.HeroAdapter;

import java.util.ArrayList;
import java.util.List;

public class L37DaoActivity extends AppCompatActivity {

    private SQLiteDatabase mWdb;
    private ListView mListView;
    private List<HeroBean> mData = new ArrayList<>();
    private HeroAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l37_dao);

        initView();
        initDatabase();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l37_lv_heroes);
        mAdapter = new HeroAdapter(this, mData);
        mListView.setAdapter(mAdapter);
    }

    private void initDatabase() {
        DaoHelper helper = new DaoHelper(this);
        helper.getReadableDatabase();
        mWdb = helper.getWritableDatabase();
    }

    public void insert(View view) {
        HeroBean hero = new HeroBean()
                .setName("星爵").setSex(HeroBean.SEX_MALE).setDescription("半神");

        ContentValues cv = new ContentValues();
        cv.put(TableHero.COL_NAME, hero.getName());
        cv.put(TableHero.COL_SEX, hero.getSex());
        cv.put(TableHero.COL_DESCRIPTION, hero.getDescription());

        mWdb.insert(TableHero.TABLE_NAME, null, cv);
        mData.add(hero);
        mAdapter.notifyDataSetChanged();
    }

    public void delete(View view) {
    }

    public void query(View view) {
    }

    public void update(View view) {
    }

}
