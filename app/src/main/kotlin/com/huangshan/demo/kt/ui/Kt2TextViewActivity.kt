package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.huangshan.demo.R

class Kt2TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l2)
    }

    fun changeTextView(view: View) {
        val textView = findViewById(R.id.text_tv_name) as TextView
        textView.text = "Kotlin is funny"
    }
}
