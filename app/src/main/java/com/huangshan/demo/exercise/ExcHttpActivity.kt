package com.huangshan.demo.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.huangshan.demo.R
import com.huangshan.demo.utils.debug
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class ExcHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_http)
    }

    fun requestImdb(v: View) {
        Thread {
            queryKey("Avengers")
        }.start()
    }

    private fun queryKey(key: String) {
        val url = URL("http://www.omdbapi.com?s=$key")
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.connectTimeout = 10 * 1000
        urlConnection.readTimeout = 10 * 1000
        urlConnection.doInput = true
        val responseCode = urlConnection.responseCode
        val inputStream = urlConnection.inputStream
        val bis = BufferedInputStream(inputStream)
        val buffer = ByteArray(1024)
        var len = 0
        var res = ""
        while (len != -1) {
            res += String(buffer, 0, len)
            len = bis.read(buffer)
        }
        inputStream.close()
        bis.close()
        debug("code: $responseCode, result: $res")
    }
}
