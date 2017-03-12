package com.huangshan.demo.exercise

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.Toast
import com.huangshan.demo.R

class PopupWindowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_window)
    }

    fun popup(view: View) {
        Toast.makeText(this, "12", Toast.LENGTH_SHORT).show()
        val contentView = LayoutInflater.from(this).inflate(R.layout.pop_content, FrameLayout(this))
        val popupWindow = PopupWindow(contentView, FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))
        popupWindow.isOutsideTouchable = true
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }
}
