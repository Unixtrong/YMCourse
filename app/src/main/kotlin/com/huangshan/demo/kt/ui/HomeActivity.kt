package com.huangshan.demo.kt.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import com.huangshan.demo.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {
        val root = findViewById(R.id.activity_home) as LinearLayout
        val regex = "Kt\\d".toRegex()
        getKotlinActivities().forEach {
            val button = Button(this)
            val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.bottomMargin = 50
            button.layoutParams = layoutParams

            button.text = (regex.find(it.simpleName)?.value + regex.replace(it.simpleName, " "))
            button.setOnClickListener { v -> startActivity(Intent(this, it)) }
            root.addView(button)
        }
    }

    private fun getKotlinActivities(): Array<Class<out Activity>> {
        return arrayOf(
                Kt1ButtonActivity::class.java,
                Kt2TextViewActivity::class.java,
                Kt3RandomActivity::class.java,
                Kt4EditActivity::class.java,
                Kt5IntentActivity::class.java
        )
    }
}
