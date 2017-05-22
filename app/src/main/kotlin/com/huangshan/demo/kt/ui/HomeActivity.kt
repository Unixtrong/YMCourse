package com.huangshan.demo.kt.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import com.huangshan.demo.R
import com.huangshan.demo.exercise.ExcDaoActivity
import com.huangshan.demo.exercise.ExcJson
import com.huangshan.demo.sample.BillActivity
import com.huangshan.demo.ui.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        println(ExcJson.hashMap())
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
                L37And39DaoActivity::class.java,
                ExcDaoActivity::class.java,
                L36MusicActivity::class.java,
                L35LifecycleActivity::class.java,
                L34ExceptionActivity::class.java,
                L32And33HttpActivity::class.java,
                L31RelativeActivity::class.java,
                BillActivity::class.java,
                L30StyleActivity::class.java,
                L29ProgressActivity::class.java,
                L28UiActivity::class.java,
                L25JsonActivity::class.java,
                L23And24FileActivity::class.java,
                L22PopupWindowActivity::class.java,
                L20And21BaseAdapterActivity::class.java,
                L19ArrayListActivity::class.java,
                L18ImplementsActivity::class.java,
                L17PreferenceActivity::class.java
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
        val regex = "((Kt|L)\\d{1,2}|Exc(^e))(And\\d{1,2})?".toRegex()
        override fun toString(): String {
            val name = clazz.simpleName
            return (regex.find(name)?.value?.replace("And", "&") ?: "App - ") + regex.replace(name, " - ")
        }
    }
}
