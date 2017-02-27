package com.huangshan.demo.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.huangshan.demo.R;

public class L15DialogActivity extends AppCompatActivity {

    boolean adan;
    int along;
    String mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l15_dialog);
        System.out.println("HS int: " + along + " str: " + mc + " adan: " + adan);
    }

    public void showSimpleDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你好");
        builder.setMessage("浩克是不是绿色的？");
        builder.setNegativeButton("不是", new L15DialogListener());
        builder.setPositiveButton("是", new L15DialogListener());
        builder.setNeutralButton("我想想", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showItemsDialog(View view) {
        String[] array = {"钢铁侠", "美国队长", "蝙蝠侠", "雷神", "奇异博士"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("谁不是漫威英雄？");
        builder.setItems(array, new L15ItemsClickListener());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private class L15ItemsClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if (which == 4) {
                Toast.makeText(L15DialogActivity.this, "bingo", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class L15DialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            // dialogInterface 指点击事件所发生的对话框

            String text; // 变量 text 被声明
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    text = "我真傻"; // 变量 text 被赋值
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    text = "老子聪明的一逼";
                    break;
                default: // 前面的 case 都不满足，就来这
                    text = "&^*%&&^";
                    break;
            }
            // 变量 text 被使用
            Toast.makeText(L15DialogActivity.this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
