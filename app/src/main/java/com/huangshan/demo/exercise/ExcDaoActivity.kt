package com.huangshan.demo.exercise

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.huangshan.demo.R
import com.huangshan.demo.bean.CardL18
import com.huangshan.demo.dao.ExcDaoHelper
import com.huangshan.demo.utils.debug

class ExcDaoActivity : AppCompatActivity() {

    val listView by lazy { findViewById(R.id.l37_lv_heroes) as ListView }
    val inflater by lazy { LayoutInflater.from(this) }
    var dao: ExcDaoHelper? = null
    var db: SQLiteDatabase? = null
        get() = dao?.writableDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l37_dao)

        init()
    }

    private fun init() {
        listView.adapter = Adapter(mutableListOf())
        dao = ExcDaoHelper(this)
    }

    fun insert(v: View) {
        val cv = ContentValues()
        cv.put("name", "Along")
        cv.put("cost", 1)
        db?.insert("table_card", null, cv)
    }

    fun delete(v: View) {}

    fun query(v: View) {
        db?.let {
            val cursor = it.query("table_card", null, null, null, null, null, null, null)
            cursor.use {
                while (cursor.moveToNext()) {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    debug("name: $name")
                }
            }
        }
    }

    fun update(v: View) {}

    inner class Adapter(val data: List<CardL18>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val holder: Holder
            if (convertView == null) {
                view = inflater.inflate(R.layout.adapter_card, parent, false)
                holder = Holder(view.findViewById(R.id.l20_tv_name) as TextView)
            } else {
                view = convertView
                holder = view.tag as Holder
            }

            holder.nameTextView.text = data[position].name
            return view
        }

        override fun getItem(position: Int) = data[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getCount() = data.size

    }

    data class Holder(var nameTextView: TextView)
}
