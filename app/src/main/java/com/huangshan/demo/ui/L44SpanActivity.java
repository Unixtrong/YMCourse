package com.huangshan.demo.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.ParcelableSpan;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L44SpanActivity extends AppCompatActivity {

    private TextView mTextView;
    private int mLinkColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l43_regex);

        mTextView = (TextView) findViewById(R.id.l43_tv_regex);
        mLinkColor = getCustomColor(R.color.weiboLink);
        mLinkColor = ContextCompat.getColor(this, R.color.weiboLink);

        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView.setText("klusidf#话题#!http://www.baidu.com/qqq/ppp?w=ok&e=80 qwetime@阿龙 56456#今天#hahah#今天222#");
        Pattern pattern = Pattern.compile("(#[\\w ]+#)|(https?://[\\w./?=&]+)|(@\\w+)");

        CharSequence originText = mTextView.getText();
        Matcher matcher = pattern.matcher(originText);
        int count = matcher.groupCount();
        Tools.debug("count: " + count);
        String toast = "";
        SpannableStringBuilder builder = new SpannableStringBuilder(originText);
        while (matcher.find()) {
            String group = matcher.group();
            toast += group + "\n";

            String topic = matcher.group(1);
            if (topic != null) {
                int start = matcher.start();
                int end = matcher.end();
                Tools.debug("start: " + start + " end: " + end);
                ForegroundColorSpan span = new ForegroundColorSpan(mLinkColor);
                builder.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            String url = matcher.group(2);
            if (url != null) {
                int start = matcher.start();
                int end = matcher.end();
                Tools.debug("start: " + start + " end: " + end);
                WeiboUrlSpan span = new WeiboUrlSpan(url);
                builder.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            String user = matcher.group(3);
            if (user != null) {
                int start = matcher.start();
                int end = matcher.end();
                Tools.debug("start: " + start + " end: " + end);
                ForegroundColorSpan span = new ForegroundColorSpan(mLinkColor);
                builder.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        mTextView.setText(builder);
        Tools.debug("result: " + toast);

    }

    @SuppressWarnings("deprecation")
    private int getCustomColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getColor(color);
        } else {
            return getResources().getColor(color);
        }
    }

    private void testBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("姓名", "阿龙");
        bundle.putLong("手机", 13999L);
    }

    private void rememberStatic() {
        Dog white = new Dog();
        white.eat();
        Dog.setFeet(1);

        Dog flower = new Dog();
        flower.eat();
    }

    private static class Dog {
        private static int FEET_COUNT = 4;
        private int hung;

        private static void setFeet(int feetCount) {
            FEET_COUNT = feetCount;
        }

        private void eat() {
            hung++;
        }
    }

    private class WeiboUrlSpan extends URLSpan implements ParcelableSpan {
        public final Creator<WeiboUrlSpan> CREATOR = new Creator<WeiboUrlSpan>() {
            @Override
            public WeiboUrlSpan createFromParcel(Parcel in) {
                return new WeiboUrlSpan(in);
            }

            @Override
            public WeiboUrlSpan[] newArray(int size) {
                return new WeiboUrlSpan[size];
            }
        };

        public WeiboUrlSpan(String url) {
            super(url);
        }

        public WeiboUrlSpan(Parcel src) {
            super(src);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
//            super.updateDrawState(ds);
            ds.setColor(mLinkColor);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
        }

        @Override
        public int describeContents() {
            return super.describeContents();
        }
    }
}
