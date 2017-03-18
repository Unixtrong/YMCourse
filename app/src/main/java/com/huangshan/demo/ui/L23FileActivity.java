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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class L23FileActivity extends AppCompatActivity {

    private static final String TAG = "L23";

    private TextView mTvContent;
    private EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l23_file);

        // byte
        // 1k = 1024 byte
        // 1 byte = 8 bit（位）
        // 00000010
        // 'a' 的大小是一个 byte
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
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load(View v) {
        File extCacheDir = getExternalCacheDir();
        File file = new File(extCacheDir, "L23.txt");
        byte[] bytes = new byte[1024];
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            int length = in.read(bytes);
            Toast.makeText(this, "len: " + length, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = new String(bytes);
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

















