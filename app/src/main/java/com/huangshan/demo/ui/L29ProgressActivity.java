package com.huangshan.demo.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.huangshan.demo.R;

public class L29ProgressActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l29_progress);
        initView();
        // 可变数组
        testValArray("Aloong", "MC");
    }

    private void testValArray(String... info) {
        String[] info1 = info;
    }

    private void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.l29_pb_hor);
        // mProgressBar.setMax(100);
    }

    public void updateProgress(View view) {
        // ++ 放前面，先加再用，++ 放后面，先用再加
        mProgressBar.setProgress(++mProgress);
        mProgressBar.setSecondaryProgress(mProgress++ * 2);
//        mProgressBar.incrementProgressBy(1);
//        mProgressBar.incrementSecondaryProgressBy(2);
    }

    public void popupProgressDialog(View view) {
        new AsyncTask<String, Void, String>() {
            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                dialog = new ProgressDialog(L29ProgressActivity.this);
                dialog.setCancelable(true);
                dialog.setTitle("我是进度条对话框");
                dialog.setMessage("等一下");
                dialog.show();
//                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                    @Override
//                    public void onCancel(DialogInterface dialog) {
//
//                    }
//                });
            }

            @Override
            protected String doInBackground(String... params) {
                downloadData(3);
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                dialog.dismiss();
//                dialog.cancel();
            }
        }.execute();
    }

    public void startDownload(View v) {
        AsyncTask<String, Integer, Integer> asyncTask = new AsyncTask<String, Integer, Integer>() {
            @Override
            protected void onPreExecute() {
                Toast.makeText(L29ProgressActivity.this, "start", Toast.LENGTH_SHORT).show();
                mProgress = mProgressBar.getMax();
                mProgressBar.setProgress(mProgress);
            }

            @Override
            protected Integer doInBackground(String... params) {
                while (mProgress > 0) {
                    downloadData(1);
                    mProgress -= 20;
                    publishProgress(mProgress);
                }
                return mProgress;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mProgressBar.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Integer result) {
                Toast.makeText(L29ProgressActivity.this, "done: " + result, Toast.LENGTH_SHORT).show();
            }
        };

        asyncTask.execute("start");
    }

    private void oldDownload() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgress < 100) {
                    downloadData(1);
                    mProgress += 20;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgress);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(L29ProgressActivity.this, "done", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    private void downloadData(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
