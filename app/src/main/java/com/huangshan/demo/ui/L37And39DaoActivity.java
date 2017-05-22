package com.huangshan.demo.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class L37And39DaoActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    private SQLiteDatabase mWdb;
    private ListView mListView;
    private List<HeroBean> mData = new ArrayList<>();
    private HeroAdapter mAdapter;
    private SQLiteDatabase mRdb;
    private List<HeroBean> mOriginalData = new ArrayList<>();
    private Random mRandom = new Random();
    private LinearLayout mFilterLayout;
    private ListPopupWindow mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l37_dao);

        initView();
        initData();
        initDatabase();
    }

    private void initView() {
        mFilterLayout = (LinearLayout) findViewById(R.id.l38_ll_filter);
        mListView = (ListView) findViewById(R.id.l37_lv_heroes);
        mAdapter = new HeroAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemLongClickListener(this);
    }

    private void initData() {
        mOriginalData.add(new HeroBean("彼得·奎恩", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "「星爵」，半神"));
        mOriginalData.add(new HeroBean("火箭", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "浣熊工程师"));
        mOriginalData.add(new HeroBean("德拉克斯", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "「毁灭者」"));
        mOriginalData.add(new HeroBean("格鲁特", HeroBean.GENDER_UNKNOWN, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "树人"));
        mOriginalData.add(new HeroBean("卡魔拉", HeroBean.GENDER_FEMALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "灭霸养女，星云姐姐"));
        mOriginalData.add(new HeroBean("勇度", HeroBean.GENDER_MALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "扫荡者"));
        mOriginalData.add(new HeroBean("星云", HeroBean.GENDER_FEMALE, HeroBean.TEAM_GUARDIAN_OF_GALAXY, "灭霸养女，卡魔拉妹妹，改造人"));
        mOriginalData.add(new HeroBean("托尼·斯塔克", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「钢铁侠」，军火商"));
        mOriginalData.add(new HeroBean("史蒂夫·罗杰斯", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「美国队长」"));
        mOriginalData.add(new HeroBean("索尔", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "「雷神」，阿兹嘉德王储"));
        mOriginalData.add(new HeroBean("布鲁斯·班纳", HeroBean.GENDER_MALE, HeroBean.TEAM_AVENGERS, "浩克"));
        mOriginalData.add(new HeroBean("娜塔莎·罗曼诺夫", HeroBean.GENDER_FEMALE, HeroBean.TEAM_AVENGERS, "「黑寡妇」"));
    }

    private void initDatabase() {
        DaoHelper helper = new DaoHelper(this);
        mRdb = helper.getReadableDatabase();
        mWdb = helper.getWritableDatabase();
    }

    public void filter(View view) {
        switch (view.getId()) {
            case R.id.l38_tv_filter_gender:
                String[] items = "男 女 未知".split(" ");
                popupMenu(view, items, new OnGenderClickListener(items));
                break;
            case R.id.l38_tv_filter_team:
                break;
            case R.id.l38_tv_sort:
                break;
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
        final HeroBean hero = (HeroBean) parent.getItemAtPosition(position);
        String[] items = "修改 删除".split(" ");
        new AlertDialog.Builder(this)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                popupEditDialog(position, hero);
                                break;
                            case 1:
                                delete(position, id);
                                break;
                        }
                    }
                })
                .create()
                .show();
        return false;
    }

    /**
     * 性别筛选条件点击事件监听器
     */
    private class OnGenderClickListener implements AdapterView.OnItemClickListener {
        private String[] items;

        private OnGenderClickListener(String[] items) {
            this.items = items;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            filterQuery(HeroBean.convertGender(items[position]), null);
            if (mWindow != null) {
                mWindow.dismiss();
            }
        }
    }

    private void filterQuery(Integer genderFilter, Integer teamFilter) {
        // 查询银河护卫队女性成员的名字和描述，并按照名字排列
        // String[] columns = {TableHero.COL_NAME, TableHero.COL_DESCRIPTION};
        // String selection = TableHero.COL_TEAM + " = ? AND " + TableHero.COL_GENDER + " = ?";
        // String[] selectionArgs = {HeroBean.TEAM_GUARDIAN_OF_GALAXY + "", HeroBean.GENDER_FEMALE + ""};

        // 查询银河护卫队女性成员的所有属性，并按照名字排列
        // String selection = TableHero.COL_TEAM + " = ? AND " + TableHero.COL_GENDER + " = ?";
        // String[] selectionArgs = {HeroBean.TEAM_GUARDIAN_OF_GALAXY + "", HeroBean.GENDER_FEMALE + ""};
        // String orderBy = TableHero.COL_NAME;

        List<String> selectionList = new ArrayList<>();
        List<String> selectionArgsList = new ArrayList<>();
        if (genderFilter != null) {
            selectionList.add(TableHero.COL_GENDER + " = ?");
            selectionArgsList.add("" + genderFilter);
        }
        if (teamFilter != null) {
            selectionList.add(TableHero.COL_TEAM + " = ?");
            selectionArgsList.add("" + teamFilter);
        }

        String[] selectionArgs = new String[selectionArgsList.size()];
        selectionArgsList.toArray(selectionArgs);

        String selection = "";
        for (int i = 0; i < selectionList.size(); i++) {
            selection += "AND " + selectionList.get(0);
        }
        selection = selection.substring(4, selection.length());

        List<HeroBean> list = new ArrayList<>();
        String orderBy = TableHero.COL_NAME;
        Cursor cursor = mRdb.query(TableHero.TABLE_NAME, null, selection, selectionArgs, null, null, orderBy);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(TableHero._ID));
            String name = cursor.getString(cursor.getColumnIndex(TableHero.COL_NAME));
            int gender = cursor.getInt(cursor.getColumnIndex(TableHero.COL_GENDER));
            int team = cursor.getInt(cursor.getColumnIndex(TableHero.COL_TEAM));
            String desc = cursor.getString(cursor.getColumnIndex(TableHero.COL_DESCRIPTION));
            list.add(new HeroBean(name, gender, team, desc).setDbId(id));
            Tools.debug("name: " + name + " desc: " + desc);
        }
        cursor.close();

        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    private void popupMenu(View anchor, String[] items, AdapterView.OnItemClickListener listener) {
        mWindow = new ListPopupWindow(this);
        mWindow.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, items));
        mWindow.setWidth(ListPopupWindow.MATCH_PARENT);
        mWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EEEEEE")));
        mWindow.setAnchorView(anchor);
        mWindow.setOnItemClickListener(listener);
        mWindow.show();
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

    private void delete(int position, long id) {
        String where = TableHero._ID + " = ?";
        String[] whereArg = {String.valueOf(id)};
        int rows = mWdb.delete(TableHero.TABLE_NAME, where, whereArg);

        if (rows > 0) {
            mData.remove(position);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void query(View view) {
        if (mFilterLayout.isShown()) {
            mFilterLayout.setVisibility(View.GONE);
        } else {
            mFilterLayout.setVisibility(View.VISIBLE);
        }
    }

    public void popupEditDialog(final int position, final HeroBean hero) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_l39_update, new LinearLayout(this));
        final EditText descEditText = (EditText) view.findViewById(R.id.l39_et_desc);
        new AlertDialog.Builder(this)
                .setView(view)
                .setNegativeButton("取消", null)
                .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String desc = descEditText.getText().toString();
                        update(position, hero.setDescription(desc));
                    }
                })
                .create()
                .show();
    }

    private void update(int position, HeroBean hero) {
        ContentValues cv = new ContentValues();
        cv.put(TableHero.COL_DESCRIPTION, hero.getDescription());

        String where = TableHero._ID + " = ?";
        String[] whereArgs = {String.valueOf(hero.getDbId())};
        int rows = mWdb.update(TableHero.TABLE_NAME, cv, where, whereArgs);

        if (rows > 0) {
            mData.remove(position);
            mData.add(position, hero);
            mAdapter.notifyDataSetChanged();
        }
    }
}
