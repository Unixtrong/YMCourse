package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.ImdbResult;
import com.huangshan.demo.bean.Movie;
import com.huangshan.demo.ui.adapter.MovieAdapter;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class L32And33HttpActivity extends AppCompatActivity {

    private ListView mMoviesListView;
    private MovieAdapter mAdapter;
    private EditText mSearchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l32_http_activiy);
        initView();
    }

    private void initView() {
        mMoviesListView = (ListView) findViewById(R.id.l33_lv_movies);
        mSearchEditText = (EditText) findViewById(R.id.l33_et_input);
    }

    public void startRequest(View view) {
        final String searchKeyword = mSearchEditText.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = requestImdb(searchKeyword);
                    ImdbResult result = ImdbResult.fill(new JSONObject(json));
                    final List<Movie> movies = Movie.fillList(result.getSearch());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new MovieAdapter(L32And33HttpActivity.this, movies);
                            mMoviesListView.setAdapter(mAdapter);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String requestImdb(String keyword) throws IOException {
        String urlAddress = "http://www.omdbapi.com?s=" + keyword;
        URL url = new URL(urlAddress);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(10 * 1000);
        urlConnection.setDoInput(true);
        int responseCode = urlConnection.getResponseCode();
        debug("requestImdb, respCode: " + responseCode);
        if (responseCode == 200) {
            InputStream inputStream = null;
            String result;
            try {
                inputStream = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int len;
                result = "";
                while ((len = inputStream.read(buffer)) != -1) {
                    result += new String(buffer, 0, len);
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private static void debug(String msg) {
        Log.d("ym", msg);
    }
}
