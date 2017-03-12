package com.huangshan.demo.kt.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.huangshan.demo.R
import com.huangshan.demo.ui.L18ImplementsActivity
import com.huangshan.demo.ui.L19ArrayListActivity
import com.huangshan.demo.ui.L20And21BaseAdapterActivity
import com.huangshan.demo.ui.L22PopupWindowActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {
        val listView = findViewById(R.id.home_lv_menu) as ListView
        listView.adapter = ArrayAdapter<ActivityInfo>(this, android.R.layout.simple_list_item_1, getCourseActivities())
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val activityInfo = adapterView.getItemAtPosition(position) as ActivityInfo
            startActivity(Intent(this, activityInfo.clazz))
        }
    }

    private fun getCourseActivities(): List<ActivityInfo> {
        return arrayOf(
                L22PopupWindowActivity::class.java,
                L20And21BaseAdapterActivity::class.java,
                L19ArrayListActivity::class.java,
                L18ImplementsActivity::class.java
        ).map(::ActivityInfo)
    }

    private fun getKotlinActivities(): Array<Class<out Activity>> {
        return arrayOf(
                Kt1ButtonActivity::class.java,
                Kt2TextViewActivity::class.java,
                Kt3RandomActivity::class.java,
                Kt4EditActivity::class.java,
                Kt5IntentActivity::class.java,
                Kt11ListViewExsActivity::class.java
        )
    }

    data class ActivityInfo(val clazz: Class<out Activity>) {
        val regex = "(Kt|L)\\d{1,2}(And\\d{1,2})?".toRegex()
        override fun toString(): String {
            return regex.find(clazz.simpleName)?.value?.replace("And", "&") + regex.replace(clazz.simpleName, " - ")
        }
    }
}
