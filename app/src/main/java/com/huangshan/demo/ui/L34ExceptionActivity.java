package com.huangshan.demo.ui;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.exception.EmptyManaException;

public class L34ExceptionActivity extends AppCompatActivity {

    private TextView mNumTextView;
    private TextView mLogTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l34_exception);
        initView();

        // Exception 分为 运行时异常 和 非运行时异常
        // 运行时异常，继承自 RuntimeException，仅在运行时发生
        // 非运行时异常无法编译通过，必须通过 catch（捕获）或者向上 throws（抛出） 处理
    }

    private void initView() {
        mNumTextView = (TextView) findViewById(R.id.l34_tv_random_number);
        mLogTextView = (TextView) findViewById(R.id.l34_tv_log);
    }

    public void start(View view) {
        startWithAsyncTask();
    }

    /**
     * 启动两个异步任务修改随机数控件
     */
    private void startWithAsyncTask() {
        log("准备启动异步任务 1，间隔 1 秒");
        // 直接调用 AsyncTask 的 execute 是串行执行所有 AsyncTask 任务
        // new RandomNumberAsyncTask("#ff4800").execute(1F);
        // 调用 AsyncTask 的 executeOnExecutor 可以在串行或并行执行中选择不同的 EXECUTOR
        new RandomNumberAsyncTask("#ff4800").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1F);
        log("准备启动异步任务 2，间隔 1.5 秒");
//        new RandomNumberAsyncTask("#00b2ff").execute(1.5F);
        new RandomNumberAsyncTask("#00b2ff").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1.5F);
        log("两个异步任务均启动完毕");
    }

    /**
     * 启动两个线程修改随机数控件
     */
    private void startWithThread() {
        log("准备启动线程 1，间隔 1 秒");
        new Thread(new RandomNumberRunnable("#ff4800", 1F)).start();
        log("准备启动线程 2，间隔 1.5 秒");
        new Thread(new RandomNumberRunnable("#00b2ff", 1.5F)).start();
        log("两个线程均启动完毕");
    }

    private class RandomNumberRunnable implements Runnable {

        private final int color;
        private float interval;

        RandomNumberRunnable(String color, float interval) {
            this.color = Color.parseColor(color);
            this.interval = interval;
        }

        @Override
        public void run() {
            int count = 10;
            while (count-- > 0) {
                sleep(interval);
                final int number = count;
                // runOnUiThread 方法来自 Activity，在非 Activity 类中无法直接调用
                // 在无法获得 Activity 对象时，使用 AsyncTask 可以避免此问题
                L34ExceptionActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mNumTextView.setTextColor(color);
                        mNumTextView.setText(number + "");
                    }
                });
            }
        }
    }

    /**
     * AsyncTask 的三个泛型
     * 第一个对应 doInBackground 的参数，和 execute 的参数
     * 第二个对应 onProgressUpdate 的参数，和 publishProgress 的参数
     * 第三个对应 doInBackground 的返回值，和 onPostExecute 的参数
     */
    private class RandomNumberAsyncTask extends AsyncTask<Float, Integer, String> {

        private int color;

        RandomNumberAsyncTask(String color) {
            this.color = Color.parseColor(color);
        }

        @Override
        protected void onPreExecute() {
            // 发生在主线程，doInBackground 之前调用
            log("异步任务执行开始 " + this);
        }

        @Override
        protected String doInBackground(Float[] params) {
            // 在调用 execute 并切换到子线程后执行此方法
            Float interval = params[0];
            int count = 10;
            while (count-- > 0) {
                sleep(interval);
                publishProgress(count);
            }
            return "异步任务执行结束 " + this;
        }
        @Override
        protected void onProgressUpdate(Integer... counts) {
            // 在子线程中调用 publishProgress 时，会切换到主线程后执行此方法
            int count = counts[0];
            mNumTextView.setTextColor(color);
            mNumTextView.setText(count + "");
        }

        @Override
        protected void onPostExecute(String o) {
            // 在执行完 doInBackground 后，切换到主线程执行此方法
            // 这里的参数是 doInBackground 的返回结果
            log(o);
        }


    }

    public void catchNull(View view) {
        try {
            String a = getHeroName();
            char initialA = a.charAt(0);
            log("catchNull 获取到首字母：" + initialA);
            String b = getHeroName();
            char initialB = b.charAt(0);
            log("catchNull 获取到首字母：" + initialB);
            String c = getHeroName();
            char initialC = c.charAt(0);
            log("catchNull 获取到首字母：" + initialC);
        } catch (NullPointerException e) {
            e.printStackTrace();
            log("catchNull 捕获到空指针异常");
        }
    }

    private String getHeroName() {
        return null;
    }

    public void catchIndexOut(View view) {
        try {
            int[] array = new int[3];
            array[0] = 0;
            array[1] = 1;
            array[2] = 2;
            int result = 1 + array[3];
            log("catchIndexOut result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            log("catchIndexOut 捕获到数组越界异常");
        }
    }

    public void catchArithmetic(View view) {
        try {
            int a = 4;
            int b = 0;
            int c = a / b;
            log("catchArithmetic c: " + c);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    public void catchCustom(View view) {
        try {
            playCardParent();
            log("catchCustom mana: " + mManaCount);
        } catch (EmptyManaException e) {
            e.printStackTrace();
            log("catchCustom 捕获到空水晶异常（自定义异常）");
            Toast.makeText(this, "没水晶了", Toast.LENGTH_SHORT).show();
        }
    }

    private int playCardParent() throws EmptyManaException {
        return playCard();
    }

    /**
     * 模拟的剩余法力水晶数目
     */
    private int mManaCount = 8;

    private int playCard() throws EmptyManaException {
        if (mManaCount <= 0) {
            throw new EmptyManaException("你没有法力水晶了");
        }
        // 打出卡牌
        int currentCardCost = 4;
        if (mManaCount >= currentCardCost) {
            mManaCount = mManaCount - currentCardCost;
        }
        return mManaCount;
    }

    private void sleep(float interval) {
        try {
            // 这就是一个典型的非运行时异常，必须处理（catch or throws）后才能编译通过
            Thread.sleep((long) (interval * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void log(String msg) {
        // append 会将新内容追加到老内容中
        mLogTextView.append(" - " + msg + "\n\n");
    }
}
