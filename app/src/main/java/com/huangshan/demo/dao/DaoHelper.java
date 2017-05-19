package com.huangshan.demo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.huangshan.demo.consts.TableHero;
import com.huangshan.demo.utils.Tools;

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
public class DaoHelper extends SQLiteOpenHelper {

    public DaoHelper(Context context) {
        super(context, "ym.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建数据库时会调用
        String sql = "CREATE TABLE " + TableHero.TABLE_NAME + "(" +
                TableHero._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TableHero.COL_NAME + " TEXT, " +
                TableHero.COL_GENDER + " INTEGER, " +
                TableHero.COL_TEAM + " INTEGER, " +
                TableHero.COL_DESCRIPTION + " TEXT)";
        Tools.debug("SQL: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 升级数据库时会调用
    }
}
