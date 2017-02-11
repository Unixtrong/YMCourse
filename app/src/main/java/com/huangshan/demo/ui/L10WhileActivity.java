package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.huangshan.demo.R;

public class L10WhileActivity extends AppCompatActivity {
    private Button mButton;
    private int mTime = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l10_while);
        mButton = (Button) findViewById(R.id.l10_btn);
        mButton.setText(mTime + "");
    }

    public void onClickTimerButton(View view) {
        // if (mTime > 5) {
        // }
        Thread thread = new Thread(new TimeRunnable());
        thread.start();
        mButton.setText("无敌");
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class TimeRunnable implements Runnable {
        @Override
        public void run() {
            while (mTime > 0) {
                sleep(1);
                mTime = mTime - 1;
                runOnUiThread(new ChangeNumberRunnable());
            }
        }
    }

    private class ChangeNumberRunnable implements Runnable {
        @Override
        public void run() {
            mButton.setText(mTime + "");
        }
    }
}
















