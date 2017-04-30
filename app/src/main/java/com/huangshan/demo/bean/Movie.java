package com.huangshan.demo.bean;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Author(s): danyun
 * Date: 2017/4/30
 */
public class Movie {
    private String mImdbId;
    private String mTitle;
    private String mType;
    private String mYear;
    private String mPosterUrl;
    private Bitmap mPosterBitmap;

    public static Movie fill(JSONObject o) {
        if (o.has("imdbID")) {
            Movie movie = new Movie();
            movie.setImdbId(o.optString("imdbID"));
            if (o.has("Title")) {
                movie.setTitle(o.optString("Title"));
            }
            if (o.has("Type")) {
                movie.setType(o.optString("Type"));
            }
            if (o.has("Year")) {
                movie.setYear(o.optString("Year"));
            }
            if (o.has("Poster")) {
                movie.setPosterUrl(o.optString("Poster"));
            }
            return movie;
        }
        return null;
    }

    public static List<Movie> fillList(JSONArray a) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            movies.add(fill(a.optJSONObject(i)));
        }
        return movies;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public Movie setImdbId(String imdbId) {
        this.mImdbId = imdbId;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public Movie setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public String getType() {
        return mType;
    }

    public Movie setType(String type) {
        this.mType = type;
        return this;
    }

    public String getYear() {
        return mYear;
    }

    public Movie setYear(String year) {
        this.mYear = year;
        return this;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public Movie setPosterUrl(String posterUrl) {
        this.mPosterUrl = posterUrl;
        return this;
    }

    public Bitmap getPosterBitmap() {
        return mPosterBitmap;
    }

    public Movie setPosterBitmap(Bitmap posterBitmap) {
        mPosterBitmap = posterBitmap;
        return this;
    }
}
