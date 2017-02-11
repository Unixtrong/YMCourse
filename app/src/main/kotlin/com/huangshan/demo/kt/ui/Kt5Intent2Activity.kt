package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.huangshan.demo.R

class Kt5Intent2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l5b)

        val dataInt = intent.getIntExtra("diaoInteger", 0)
        val dataStr = intent.getStringExtra("diaoString")
        val tvData = findViewById(R.id.l5b_tv_data) as TextView
        tvData.text = "得到数字：$dataInt，得到字符串：$dataStr"
    }
}
