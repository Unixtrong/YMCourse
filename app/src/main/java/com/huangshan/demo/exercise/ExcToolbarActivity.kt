package com.huangshan.demo.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.huangshan.demo.R
import com.huangshan.demo.utils.Tools

class ExcToolbarActivity : AppCompatActivity() {

    private val mToolbar: Toolbar by lazy { findViewById(R.id.exc_tb) as Toolbar }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_toolbar)
        setSupportActionBar(mToolbar)

        mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white)
        mToolbar.setLogo(R.mipmap.ic_hearthstone_logo2)
        mToolbar.title = "Tony Stark"
        mToolbar.subtitle = "Icon Man"
        mToolbar.titleMarginStart = 70
//        mToolbar.setOnMenuItemClickListener { item: MenuItem ->
//            val msg: String = when (item.itemId) {
//                R.id.action_edit -> "Edit"
//                R.id.action_share -> "Share"
//                R.id.action_settings -> "Settings"
//                else -> "Error"
//            }
//            Tools.toast(this, "> " + msg)
//            return@setOnMenuItemClickListener true
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.l40_menu, menu)
        return true
    }
}
