package com.huangshan.demo.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.Card;
import com.huangshan.demo.bean.SpellCard;

public class StandardNameActivity extends AppCompatActivity {

    // 常量
    public static final String APP_TAG = "Mountain";
    public static final int MAX_CARD_NUMBER = 8;
    public static final long CURRENT_DATE_NUMBER = 20170325L;

    // 类变量
    private static String sLastHero = "Hulk";
    private static boolean sBtnClickable;
    private static int sCurrentHandCardNumber;

    // 成员变量
    private Button mBtnShow;
    private String mHeroName;
    private int mCurrentCost = 3;

    static {
        sLastHero = "Green Hulk";
        sBtnClickable = true;
        sCurrentHandCardNumber = 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_name);
        mBtnShow = (Button) findViewById(R.id.exc_btn_demo);
        mHeroName = "Thor";
        mCurrentCost = 4;
    }

    // 方法
    public void onClick(View view) { // <- 参数
        // 本地变量
        int arraySize = 10;
        Card card = new Card();

        String content = APP_TAG + MAX_CARD_NUMBER + CURRENT_DATE_NUMBER
                + sLastHero + sBtnClickable + sCurrentHandCardNumber
                + mBtnShow.getText() + mHeroName + mCurrentCost
                + arraySize + card.toString() + new GoteCoin("").throwCard();
        Log.d(APP_TAG, content);
    }

    // 类
    private static class GoteCoin extends SpellCard implements ThrowableCard {
        GoteCoin(String name) {
            super(name);
        }

        @Override
        public String throwCard() {
            return "throw: " + getName();
        }
    }

    // 接口
    private interface ThrowableCard {
        String throwCard();
    }
}
