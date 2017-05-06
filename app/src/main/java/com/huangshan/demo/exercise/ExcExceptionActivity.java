package com.huangshan.demo.exercise;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.exception.EmptyManaException;
import com.huangshan.demo.utils.Tools;

import java.util.Random;

public class ExcExceptionActivity extends AppCompatActivity {

    private TextView mNumTextView;
    private TextView mLogTextView;
    private Random mRandom;
    private int mManaCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l34_exception);
        mRandom = new Random();
        mLogTextView = (TextView) findViewById(R.id.l34_tv_log);
        mNumTextView = (TextView) findViewById(R.id.l34_tv_random_number);
    }

    public void start(View view) {
        startWithAsyncTask();
    }

    private void startWithAsyncTask() {
        new RandomNumberAsyncTask("#00B2FF").execute(1F);
        new RandomNumberAsyncTask("#FF4800").execute(1.5F);
    }

    private class RandomNumberAsyncTask extends AsyncTask<Float, Integer, Void> {

        private int color;
        RandomNumberAsyncTask(String color) {
            this.color = Color.parseColor(color);
        }

        @Override
        protected Void doInBackground(Float... params) {
            Float interval = params[0];
            int count = 10;
            while (count-- > 0) {
                sleep(interval);
                publishProgress(count);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mNumTextView.setTextColor(color);
            mNumTextView.setText(values[0] + "");
        }
    }

    private void startWithThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                while (count-- > 0) {
                    sleep(1);
                    final int number = count;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mNumTextView.setTextColor(Color.parseColor("#00B2FF"));
                            mNumTextView.setText(number + "");
                        }
                    });
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 10) {
                    sleep(1.5F);
                    final int number = count;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mNumTextView.setTextColor(Color.parseColor("#FF4800"));
                            mNumTextView.setText(number + "");
                        }
                    });
                }
            }
        }).start();
    }

    private void sleep(float time) {
        try {
            Thread.sleep((long) (time * 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void appendLog(String msg) {
        mLogTextView.append(msg + "\n");
    }

    private void catchEmptyMana() {
        int count = 0;
        try {
            count = playCard();
        } catch (EmptyManaException e) {
            e.printStackTrace();
        }
        appendLog("法力水晶剩余：" + count);
    }

    private void catchArithmetic() {
        try {
            int a = 4 / 0;
        } catch (ArithmeticException e) {
            appendLog("捕获到了除零异常");
            Tools.warn("捕获到了除零异常", e);
        }
    }

    private void catchNullPointer() {
        try {
            String name = getHeroName();
            char initial = name.charAt(0);
            appendLog("正常获得了首字母：" + initial);
        } catch (NullPointerException e) {
            appendLog("捕获到了空指针异常");
            Tools.warn("捕获到了空指针异常", e);
        }
    }

    private int playCard() throws EmptyManaException {
        if (mManaCount == 0) {
            throw new EmptyManaException("");
        }
        return mManaCount--;
    }

    private String getHeroName() {
        if (mRandom.nextBoolean()) {
            return null;
        } else {
            return "StarLord";
        }
    }
}
