package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.huangshan.demo.R

class Kt1ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l1)
    }

    fun clickButton(view: View) {
        if (view.id == R.id.main_btn_1) {
            shortShow("click 1")
        }
        if (view.id == R.id.main_btn_2) {
            shortShow("click 2")
        }
    }

    private fun shortShow(content: String) {
        Toast.makeText(this@Kt1ButtonActivity, content, Toast.LENGTH_SHORT).show()
    }
}
