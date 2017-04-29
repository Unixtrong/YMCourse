package com.huangshan.demo.utils

import android.util.Log

/**
 * Author(s): danyun
 * Date: 2017/4/28
 */

fun debug(msg: String) {
    val ste = Throwable().stackTrace[1]
    val className = ste.className
    val methodName = ste.methodName
    Log.d("ym", "$className $methodName, $msg")
}