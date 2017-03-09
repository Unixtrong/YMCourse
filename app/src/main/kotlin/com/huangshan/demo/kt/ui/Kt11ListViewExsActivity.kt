package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.huangshan.demo.R
import java.util.*

class Kt11ListViewExsActivity : AppCompatActivity() {
    val mRandom: Random = Random()
    var mListView: ListView? = null
    var mCostArray: IntArray? = null
    var mMinCost: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt11_list_view_exs)
        initView()
        initData()
    }

    private fun initView() {
        mListView = findViewById(R.id.l11_exs_lv) as ListView
    }

    private fun initData() {
        val nameArray = arrayOf("安度因", "杜隆坦", "古尔丹", "耐奥组", "雷克萨", "吉安娜", "麦迪文", "卡德加")
        mCostArray = IntArray(nameArray.size)
        for ((index, name) in nameArray.withIndex()) {
            val cost = mRandom.nextInt(nameArray.size)
            mCostArray?.set(index, cost)
            nameArray[index] = "$name - $cost"
        }
        mMinCost = mCostArray?.min()?:0
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameArray)
        mListView?.adapter = adapter
        mListView?.setOnItemClickListener { adapterView, view, position, id ->
            val cost = mCostArray?.get(position)?: Int.MAX_VALUE
            val costNumber = if (cost <= mMinCost) "bingo" else "T_T"
            Toast.makeText(this, costNumber, Toast.LENGTH_SHORT).show()
        }
    }
}
