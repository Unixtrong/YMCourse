package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;

public class L9ThreadActivity extends AppCompatActivity {
    private TextView mTvContent;
    boolean mClickable;
    int uuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l9_thread);
        initView();
        int a = 9;
        String b = "asdbsdfg";
        boolean aaa = true;
        boolean bbb = false;
        mClickable = true;
        if (mClickable) {
        }

    }

    private void initView() {
        mTvContent = (TextView) findViewById(R.id.l9_tv_content);
    }

    public void startTimer(View button) {
        ChangeTextTimer textTimer = new ChangeTextTimer();
        Thread thread = new Thread(textTimer);
        thread.start();
        mTvContent.setText("劳资最最最最屌！！！！！");
    }

    private class ChangeTextTimer implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            runOnUiThread(new ChangeTextRunnable());
        }
    }

    private class ChangeTextRunnable implements Runnable {
        @Override
        public void run() {
            mTvContent.setText("屌不过 5 秒");
        }
    }
}
