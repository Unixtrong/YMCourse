package com.huangshan.demo.exercise

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.huangshan.demo.R
import com.huangshan.demo.bean.ExcMovie
import com.huangshan.demo.utils.debug
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL

class ExcHttpActivity : AppCompatActivity() {

    val moviesListView by lazy { findViewById(R.id.exc_lv_movies) as ListView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_http)
    }

    fun requestImdb(v: View) {
        Thread {
            val json = queryKey("Avengers")
            val movieList = ExcMovie.fillList(JSONObject(json).optJSONArray("Search"))
            debug("movieList size: ${movieList.size}")
            runOnUiThread {
                moviesListView.adapter = Adapter(movieList)
            }
        }.start()
    }

    private fun queryKey(key: String): String {
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
        return res
    }

    inner class Adapter(val data: List<ExcMovie>) : BaseAdapter() {

        val inflater: LayoutInflater = LayoutInflater.from(this@ExcHttpActivity)

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val holder: MovieHolder
            val itemView: View
            if (convertView == null) {
                itemView = inflater.inflate(R.layout.adapter_l33_movies, parent, false)
                val titleTextView = itemView.findViewById(R.id.l33_tv_title) as TextView
                val yearTextView = itemView.findViewById(R.id.l33_tv_year) as TextView
                val posterImageView = itemView.findViewById(R.id.l33_iv_poster) as ImageView
                holder = MovieHolder(titleTextView, yearTextView, posterImageView)
                itemView.tag = holder
            } else {
                itemView = convertView
                holder = itemView.tag as MovieHolder
            }
            val movie = data[position]
            holder.titleTextView.text = movie.title
            holder.yearTextView.text = movie.year
            if (movie.posterData == null) {
                holder.posterImageView.setImageResource(R.mipmap.ic_launcher)
                Thread {
                    val bitmap = downloadPoster(movie.poster)
                    movie.posterData = bitmap
                    runOnUiThread { holder.posterImageView.setImageBitmap(bitmap) }
                }.start()
            } else {
                holder.posterImageView.setImageBitmap(movie.posterData)
            }
            return itemView
        }

        override fun getItem(position: Int): ExcMovie {
            return data[position]
        }

        override fun getItemId(position: Int): Long {
            return data[position].imdbId.replace("tt", "", true).toLong()
        }

        override fun getCount(): Int {
            return data.size
        }
    }

    private fun downloadPoster(urlOri: String): Bitmap? {
        val urlAddress = urlOri.replace("300", "50", false)
        val url = URL(urlAddress)
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.connectTimeout = 10 * 1000
        urlConnection.readTimeout = 10 * 1000
        val responseCode = urlConnection.responseCode
        if (responseCode == 200) {
            val inputStream = urlConnection.inputStream
            val buffer = ByteArray(1024)
            var length = 0
            val outputStream = ByteArrayOutputStream()
            while (length != -1) {
                outputStream.write(buffer, 0, length)
                length = inputStream.read(buffer)
            }
            val bytes = outputStream.toByteArray()
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        }
        return null
    }

    data class MovieHolder(val titleTextView: TextView, val yearTextView: TextView, val posterImageView: ImageView)
}
