package com.huangshan.demo.exercise

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.huangshan.demo.R
import com.huangshan.demo.utils.debug

class ExcLifecycleActivity : AppCompatActivity() {
    val nameTextView by lazy { findViewById(R.id.exc_tv_activity_name) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        debug(".")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_lifecycle)
        nameTextView.text = "Activity 1"
    }

    fun newActivity1(v: View) {
        startActivity(Intent(this, ExcLifecycleActivity::class.java))
    }

    fun newActivity2(v: View) {
        startActivity(Intent(this, ExcLifecycleActivity2::class.java))
    }

    override fun onRestart() {
        debug(".")
        super.onRestart()
    }

    override fun onStart() {
        debug(".")
        super.onStart()
    }

    override fun onResume() {
        debug(".")
        super.onResume()
    }

    override fun onPause() {
        debug(".")
        super.onPause()
    }

    override fun onStop() {
        debug(".")
        super.onStop()
    }

    override fun onDestroy() {
        debug(".")
        super.onDestroy()
    }

}
