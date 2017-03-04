package com.huangshan.demo.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.consts.SpKeyConst;

public class L17PreferenceActivity extends AppCompatActivity {
    private final static int NUMBER = 9;
    private final static String TAG = "L17";
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l17);
        initView();
        initData();
        // Android 中存储数据的三种方式
        // 1. 数据库
        // 2. 文件
        // 3. SharePreference
    }

    private void initData() {
        String name = loadName();
        Toast.makeText(this, "你好：" + name, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mEdit = (EditText) findViewById(R.id.l17_et);
    }

    /**
     * 从 sp 中加载数据
     */
    private String loadName() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        return sp.getString(SpKeyConst.KEY_NAME, "?");
    }

    /**
     * 把数据保存至 sp 中
     */
    private void saveName(String name) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SpKeyConst.KEY_NAME, name);
        editor.commit();
    }

    private void learnDataType() {
        // 基本类型，float 和 double 做运算时要注意
        boolean a;
        int b = 1;
        long c = 21000000000000L;
        float d = 3.1F;
        double e = 8;
        char f = '?';
        byte g = 43;
        String s = "[你好]";

        // 字符可做运算
        char letter1 = 'A';
        char letter2 = 'a';
        char number1 = '5';
        Log.d(TAG, "letter1=" + (char) (letter1 + 1));
        Log.d(TAG, "letter2=" + (char) (letter2 + 1));
        Log.d(TAG, "number1=" + (char) (number1 + 1));

        // 利用 char 循环输出 A ~ Z
        for (char i = 'A'; i <= 'Z'; i++) {
            Log.d(TAG, "letter: " + i);
        }

        // 通过字符串得到字符
        String str = "Aloong";
        char[] cc = str.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            Log.d(TAG, "for: " + cc[i]);
        }
    }

    public void onClick(View view) {
        String name = mEdit.getText().toString();
        saveName(name);
    }
}
