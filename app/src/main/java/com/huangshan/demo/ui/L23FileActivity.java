package com.huangshan.demo.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L23FileActivity extends AppCompatActivity {

    private static final String TAG = "L23";

    private TextView mTvContent;
    private EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l23_file);

        // 1 2 4 8 16 32 64 128 256 512 1024
        // byte
        // 1k = 1024 byte
        // 1 byte = 8 bit（位）
        // 00000001 = 1 = 2^0
        // 00000010 = 2 = 2^1
        // 00000100 = 4 = 2^2
        // 00001000 = 8 = 2^3
        // 00001010 = 8 + 2 = 10
        // 00001111 = 8 + 4 + 2 + 1 = 15
        // 10000000 = 128 = 2^7
        // 11111111 = 255 = 2^8 - 1
        // 0 1111111
        // 1 1111111
        //100000000 = 2^8
        // 'a' 的大小是一个 byte
        // Byte.MAX_VALUE == 2^7 - 1
        // Integer.MAX_VALUE = 2^31 - 1 = 2^7 * 2^8 * 2^8 * 2^8 - 1;
        // 01111111 11111111 11111111 11111111 = 2^31 - 1
        // 11111111 11111111 11111111 11111111 = 2^32 - 1
        //1 00000000 00000000 00000000 00000000 = 2^32
        // 一个 int 型，占 4 个 byte
        // int a = 1;
        initView();

    }

    private void initView() {
        mTvContent = (TextView) findViewById(R.id.l23_tv_content);
        mEtInput = (EditText) findViewById(R.id.l23_et_input);
    }

    public void save(View v) {
        Editable editable = mEtInput.getText();
        String input = editable.toString();
        // 获取 sdCard 上本应用的缓存路径
        File extCacheDir = getExternalCacheDir();
        // 在以上路径中，新建一个名为 L23.txt 的文件
        File file = new File(extCacheDir, "L23.txt");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tools.closeStream(out);
    }

    public void load(View v) {
        File extCacheDir = getExternalCacheDir();
        File file = new File(extCacheDir, "L23.txt");
        byte[] bytes = new byte[20];
        FileInputStream in = null;
        String content = "";
        try {
            in = new FileInputStream(file);
            int len;
            while ((len = in.read(bytes)) != -1) {
                String currentContent = new String(bytes, 0, len);
                content = content + currentContent;
                Log.d(TAG, "nano:" + System.nanoTime() + " Length: " + len + " cur: " + currentContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tools.closeStream(in);
        mTvContent.setText(content);
    }

    public void seePath(View v) {
        File cacheDir = getCacheDir();
        File filesDir = getFilesDir();
        File extCacheDir = getExternalCacheDir();
        File extFilesDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File rootDir = Environment.getRootDirectory();
        File dataDir = Environment.getDataDirectory();
        File downloadCacheDir = Environment.getDownloadCacheDirectory();
        File extStoragePublicDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String buffer = "cacheDir: " + cacheDir.getAbsolutePath()
                + "\n\n filesDir: " + filesDir.getAbsolutePath()
                + "\n\n extCacheDir: " + extCacheDir.getAbsolutePath()
                + "\n\n extFilesDir: " + extFilesDir.getAbsolutePath()
                + "\n\n rootDir: " + rootDir.getAbsolutePath()
                + "\n\n dataDir: " + dataDir.getAbsolutePath()
                + "\n\n downloadCacheDir: " + downloadCacheDir.getAbsolutePath()
                + "\n\n extStoragePublicDir: " + extStoragePublicDir.getAbsolutePath();
        mTvContent.setText(buffer);
    }
}

















