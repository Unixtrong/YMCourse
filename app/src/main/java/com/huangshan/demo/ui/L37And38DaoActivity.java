package com.huangshan.demo.ui;

import android.content.ContentValues;
import android.database.Cursor;
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
import com.huangshan.demo.utils.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L37And38DaoActivity extends AppCompatActivity {

    private SQLiteDatabase mWdb;
    private ListView mListView;
    private List<HeroBean> mData = new ArrayList<>();
    private HeroAdapter mAdapter;
    private SQLiteDatabase mRdb;
    private List<HeroBean> mOriginalData = new ArrayList<>();
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l37_dao);

        initView();
        initData();
        initDatabase();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.l37_lv_heroes);
        mAdapter = new HeroAdapter(this, mData);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {
        mOriginalData.add(new HeroBean("彼得·奎恩", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "「星爵」，半神"));
        mOriginalData.add(new HeroBean("火箭", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "浣熊工程师"));
        mOriginalData.add(new HeroBean("德拉克斯", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "「毁灭者」"));
        mOriginalData.add(new HeroBean("格鲁特", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "树人"));
        mOriginalData.add(new HeroBean("卡魔拉", HeroBean.GENDER_FEMALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "灭霸养女，星云姐姐"));
        mOriginalData.add(new HeroBean("勇度", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "扫荡者"));
        mOriginalData.add(new HeroBean("星云", HeroBean.GENDER_FEMALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "灭霸养女，卡魔拉妹妹，改造人"));
        mOriginalData.add(new HeroBean("托尼·斯塔克", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「钢铁侠」，军火商"));
        mOriginalData.add(new HeroBean("史蒂夫·罗杰斯", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「美国队长」"));
        mOriginalData.add(new HeroBean("索尔", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「雷神」，阿兹嘉德王储"));
        mOriginalData.add(new HeroBean("布鲁斯·班纳", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "浩克"));
        mOriginalData.add(new HeroBean("娜塔莎·罗曼诺夫", HeroBean.GENDER_FEMALE, HeroBean.TEAM_AVENGERS, "「黑寡妇」"));
        HeroBean heroBean = new HeroBean();

    }

    private void initDatabase() {
        DaoHelper helper = new DaoHelper(this);
        mRdb = helper.getReadableDatabase();
        mWdb = helper.getWritableDatabase();
    }

    public void insert(View view) {
//        if (mOriginalData.isEmpty()) {
//            Tools.toast(this, "准备的数据用完了");
//            return;
//        }
        int index = mRandom.nextInt(mOriginalData.size());
        HeroBean hero = mOriginalData.get(index);
//        mOriginalData.remove(index);

        ContentValues cv = new ContentValues();
        cv.put(TableHero.COL_NAME, hero.getName());
        cv.put(TableHero.COL_GENDER, hero.getGender());
        cv.put(TableHero.COL_TEAM, hero.getTeam());
        cv.put(TableHero.COL_DESCRIPTION, hero.getDescription());

        long rowId = mWdb.insert(TableHero.TABLE_NAME, null, cv);
        Tools.debug("rowId: " + rowId);
        if (rowId != -1) {
            mData.add(hero);
            mAdapter.notifyDataSetChanged();
        }

        // 插入数据冲突时，自行捕获异常
        // try {
        //     mWdb.insertOrThrow(TableHero.TABLE_NAME, null, cv);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }

        // 自定义冲突策略
        //mWdb.insertWithOnConflict(TableHero.TABLE_NAME, null, cv, SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void delete(View view) {
        String whereClause = TableHero.COL_GENDER + "=?";
        String[] whereArgs = {"" + HeroBean.GENDER_MALE};
        mWdb.delete(TableHero.TABLE_NAME, whereClause, whereArgs);
    }

    public void query(View view) {
        // 查询银河护卫队女性成员的名字和描述，并按照名字排列
        // String[] columns = {TableHero.COL_NAME, TableHero.COL_DESCRIPTION};
        // String selection = TableHero.COL_TEAM + " = ? AND " + TableHero.COL_GENDER + " = ?";
        // String[] selectionArgs = {HeroBean.TEAM_GUARDIAN_OF_GALAXY + "", HeroBean.GENDER_FEMALE + ""};

        // 查询银河护卫队女性成员的所有属性，并按照名字排列
        // String selection = TableHero.COL_TEAM + " = ? AND " + TableHero.COL_GENDER + " = ?";
        // String[] selectionArgs = {HeroBean.TEAM_GUARDIAN_OF_GALAXY + "", HeroBean.GENDER_FEMALE + ""};
        // String orderBy = TableHero.COL_NAME;

        List<HeroBean> list = new ArrayList<>();
        // 查询所有数据，并按照名字排列
        String orderBy = TableHero.COL_NAME;
        Cursor cursor = mRdb.query(TableHero.TABLE_NAME, null, null, null, null, null, orderBy);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(TableHero.COL_NAME));
            int gender = cursor.getInt(cursor.getColumnIndex(TableHero.COL_GENDER));
            int team = cursor.getInt(cursor.getColumnIndex(TableHero.COL_TEAM));
            String desc = cursor.getString(cursor.getColumnIndex(TableHero.COL_DESCRIPTION));
            list.add(new HeroBean(name, gender, team, desc));
            Tools.debug("name: " + name + " desc: " + desc);
        }
        cursor.close();

        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void update(View view) {
        ContentValues cv = new ContentValues();
        cv.put(TableHero.COL_TEAM, 0);
        String whereClause = TableHero.COL_TEAM + "=?";
        String[] whereArgs = {HeroBean.TEAM_AVENGERS + ""};
        mWdb.update(TableHero.TABLE_NAME, cv, whereClause, whereArgs);
    }
}
