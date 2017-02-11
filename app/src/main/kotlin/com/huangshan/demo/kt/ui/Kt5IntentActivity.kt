package com.huangshan.demo.kt.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.huangshan.demo.R

class Kt5IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l5)
    }

    fun enterNext(view: View) {
        startActivity(Intent().apply {
            setClass(this@Kt5IntentActivity, Kt5Intent2Activity::class.java)
            putExtra("diaoInteger", 666)
            putExtra("diaoString", "hello")
        })
    }
}
