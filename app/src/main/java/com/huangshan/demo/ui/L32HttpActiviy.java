package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class L32HttpActiviy extends AppCompatActivity {

    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l32_http_activiy);
        mContentTextView = (TextView) findViewById(R.id.l32_tv_content);
    }

    public void startRequest(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String result = requestImdb("Avengers");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mContentTextView.setText(result);
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
