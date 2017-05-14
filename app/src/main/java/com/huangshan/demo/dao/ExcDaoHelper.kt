package com.huangshan.demo.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
class ExcDaoHelper(context: Context) : SQLiteOpenHelper(context, "ym.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE table_card(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR, cost INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}