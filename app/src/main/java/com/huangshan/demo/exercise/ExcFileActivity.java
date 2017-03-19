package com.huangshan.demo.exercise;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.huangshan.demo.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class ExcFileActivity extends AppCompatActivity {

    private TextView mTvContent;
    private EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mTvContent = (TextView) findViewById(R.id.exc_file_tv);
        mEtInput = (EditText) findViewById(R.id.exc_file_et);
        System.out.println("Inn Files: " + getFilesDir());
        System.out.println("Inn Cache: " + getCacheDir());
        System.out.println("Inn ExCac: " + getExternalCacheDir());
        System.out.println("Inn ExFiD: " + getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
        System.out.println("Env Root : " + Environment.getRootDirectory());
        System.out.println("Env DoCac: " + Environment.getDownloadCacheDirectory());
        System.out.println("Env Data : " + Environment.getDataDirectory());
        System.out.println("Env ESDir: " + Environment.getExternalStorageDirectory());
        System.out.println("Env ESP  : " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        System.out.println("Env ESSta: " + Environment.getExternalStorageState());
    }

    public void save(View view) {
        File file = new File(getExternalCacheDir(), "hello");
        System.out.println("Env file : " + file);
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(mEtInput.getText().toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void load(View view) {
        File file = new File(getExternalCacheDir(), "hello");
        FileInputStream in = null;
        byte[] buffer = new byte[5];
        try {
            in = new FileInputStream(file);
            int len;
            String builder = "";
            while ((len = in.read(buffer)) != -1) {
                builder = builder + new String(buffer, 0, len);
                byte[] res = Arrays.copyOf(buffer, len);
                System.out.println("len: " + len + " buffer: " + Arrays.toString(res));
            }
            mTvContent.setText(builder);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String bit(byte a) {
        int b = 0xfffffff & a;
        return "" + b;
    }

}
