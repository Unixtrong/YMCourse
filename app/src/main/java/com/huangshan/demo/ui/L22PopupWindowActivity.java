package com.huangshan.demo.ui;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.huangshan.demo.R;

import java.util.Random;

public class L22PopupWindowActivity extends AppCompatActivity {
    private int[] imageIds = {
            R.mipmap.image_first,
            R.mipmap.image_second,
            R.mipmap.image_third
    };
    private String[] titleIds = {
            "百变泽鲁斯",
            "着魔村民",
            "晋级仪式"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l22_popup_window);
    }

    public void popup(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout root = new LinearLayout(this);
        View contentView = inflater.inflate(R.layout.popup_window_content, root);
        TextView tvTitle = (TextView) contentView.findViewById(R.id.pop_tv_title);
        ImageView iv = (ImageView) contentView.findViewById(R.id.pop_iv);
        final int number = new Random().nextInt(imageIds.length);
        tvTitle.setText(titleIds[number]);
        iv.setImageResource(imageIds[number]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(L22PopupWindowActivity.this, titleIds[number], Toast.LENGTH_SHORT).show();
            }
        });

        int warp = LinearLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(contentView, warp, warp);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
//        popupWindow.showAsDropDown(view, 100, 100);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

}
