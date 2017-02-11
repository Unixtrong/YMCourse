package com.huangshan.demo.kt.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.huangshan.demo.R

class Kt4EditActivity : AppCompatActivity() {

    private var etName: EditText? = null
    private var etNumber: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l4)
        etName = findViewById(R.id.l4_et_name) as EditText
        etNumber = findViewById(R.id.l4_et_number) as EditText
    }

    fun getEditTextName(view: View) {
        toast("今日では、最も強力な男\n${etName?.text.toString()}")
    }

    fun changeStringToNumber(view: View) {
        toast("它的两倍是: ${etNumber?.text.toString().toInt() * 2}")
    }

    private fun toast(content: String) {
        Toast.makeText(this@Kt4EditActivity, content, Toast.LENGTH_SHORT).show()
    }
}
