package com.huangshan.demo.bean

import android.graphics.Bitmap
import org.json.JSONArray
import org.json.JSONObject

/**
 * Author(s): danyun
 * Date: 2017/4/30
 */
data class ExcMovie(val imdbId: String) {
    var title: String = ""
    var type: String = ""
    var year: String = ""
    var poster: String = ""
    var posterData: Bitmap? = null

    companion object {
        fun fill(o: JSONObject): ExcMovie {
            return ExcMovie(if (o.has("imdbID")) {
                o.optString("imdbID")
            } else {
                "errorId"
            }).apply {
                if (o.has("Title")) {
                    title = o.optString("Title")
                }
                if (o.has("Year")) {
                    year = o.optString("Year")
                }
                if (o.has("Type")) {
                    type = o.optString("Type")
                }
                if (o.has("Poster")) {
                    poster = o.optString("Poster")
                }
            }
        }

        fun fillList(array: JSONArray): List<ExcMovie> {
            return (0 until array.length()).map { fill(array.optJSONObject(it)) }
        }
    }
}