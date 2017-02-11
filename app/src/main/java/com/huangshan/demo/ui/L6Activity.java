package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.huangshan.demo.R;

import java.util.Random;

public class L6Activity extends AppCompatActivity {
    String l6Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l6);
    }

    public void toastIntArray(View view) {
        int[] array = new int[3];
        array[0] = 333;
        array[1] = 666;
        array[2] = 999;
        String content = "a0: " + array[0] + "\na1: " + array[1] + "\na2: " + array[2];
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    public void changeImage(View view) {
        // 1. 将需要的图片资源 id 放入数组中
        int[] array = new int[3];
        array[0] = R.mipmap.image_first;
        array[1] = R.mipmap.image_second;
        array[2] = R.mipmap.image_third;
        // 2. 随机一个数组的整型序号
        int index = new Random().nextInt(3);
        // 3. 获取图片控件
        ImageView imageZelusi = (ImageView) findViewById(R.id.l6_iv_first);
        // 4. 设置一张新图片
        imageZelusi.setImageResource(array[index]);
    }
}
