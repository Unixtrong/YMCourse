package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.huangshan.demo.R
import java.util.*

class Kt3RandomActivity : AppCompatActivity() {
    private var count = 0
    private val random = Random()
    private val ids = intArrayOf(R.id.l3_tv_num1, R.id.l3_tv_num2, R.id.l3_tv_num3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l3)
    }

    fun randomNumber(view: View) {
        changeNumber(count++)
        if (count > 2) count = 0
    }

    private fun changeNumber(count: Int) {
        val ranNum = random.nextInt(100)
        val tvNum = findViewById(ids[count]) as TextView
        tvNum.text = "变${count + 1}: $ranNum"
    }
}
