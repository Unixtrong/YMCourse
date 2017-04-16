package com.huangshan.demo.exercise;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.huangshan.demo.R;

import java.util.concurrent.TimeUnit;

public class ExcProgressActivity extends AppCompatActivity {

    private boolean mAlertShown;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exc_progress);
        mProgressBar = (ProgressBar) findViewById(R.id.exc_pb_hor);
    }

    public void updateProgress(View view) {
        mProgressBar.incrementProgressBy(1);
        mProgressBar.incrementSecondaryProgressBy(2);
        if (!mAlertShown) {
            new AsyncTask<Void, Integer, Void>() {
                ProgressDialog dialog;
                int progress = 0;

                @Override
                protected void onPreExecute() {
                    dialog = new ProgressDialog(ExcProgressActivity.this);
                    dialog.setTitle("YEP");
                    dialog.setMessage("Hello!");
                    dialog.setCancelable(true);
                    dialog.show();
                }

                @Override
                protected Void doInBackground(Void... params) {
                    while (progress++ <= 100) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        publishProgress(progress);
                    }
                    return null;
                }

                @Override
                protected void onProgressUpdate(Integer... values) {
                    dialog.setProgress(values[0]);
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    dialog.cancel();
                }
            }.execute();

            mAlertShown = true;
        }
    }


}
