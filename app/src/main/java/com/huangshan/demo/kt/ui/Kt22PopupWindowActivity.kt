package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.huangshan.demo.R

class Kt22PopupWindowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt22_popup_window)

        foo()
    }

    fun String?.isNullOrEmpty(): Boolean {
        return this == null || this.isEmpty()
    }

    private fun foo() {
        Thread {
            val textArray = arrayOf("！", "好", "法", "大", "Kotlin")
            val result = intArrayOf(7, 6, 5, 4, 3, 2, 1, 0)
                    .filter { it < textArray.size }
                    .map { textArray[it] }
                    .reduce { a, b -> "$a$b" }
            runOnUiThread { println(result) }
        }.start()
    }
}
