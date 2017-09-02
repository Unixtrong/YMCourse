package com.huangshan.demo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L43RegexActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l43_regex);

        mTextView = (TextView) findViewById(R.id.l43_tv_regex);
        mEditText = (EditText) findViewById(R.id.l43_et_input);
        mTextView.setText("klusidf#话题#!http://www.baidu.com/qqq/ppp?w=ok&e=80 qwetime@阿龙 56456#今天#hahah#今天222#");
        Pattern pattern = Pattern.compile("((#[\\w ]+#)|(https?://[\\w./?=&]+)|(@\\w+))");

        Matcher matcher = pattern.matcher(mTextView.getText());
        int count = matcher.groupCount();
        Tools.debug("count: " + count);
        String toast = "";
        while (matcher.find()) {
            String group = matcher.group();
            toast += group + "\n";
        }
        Tools.debug("result: " + toast);

    }

    private void testFlag() {
        String text = "today, along:'content', sp, hahaha!";
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        Pattern pattern = Pattern.compile("c\\w+t");
        Matcher matcher = pattern.matcher(text);
        int count = matcher.groupCount();
        Tools.debug("count: " + count);
        String toast = "";
        while (matcher.find()) {
            toast = matcher.group();
            ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
            builder.setSpan(span, matcher.start(), matcher.end(), SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
        }
        mEditText.setText(builder);
        Tools.debug("result: " + toast);
    }

    private void multiRegex() {
        mTextView.setText("2017:mc:\"today, along:'content45645', sp, hahaha!\"...");
        Pattern pattern = Pattern.compile(".+(mc:\"(.+(along:'(\\w+)').+)\").+");

        Matcher matcher = pattern.matcher(mTextView.getText());
        int count = matcher.groupCount();
        Tools.debug("count: " + count);
        String toast = "";
        while (matcher.find()) {
            String group = matcher.group();
            toast += group + "\n";
            for (int i = 0; i <= matcher.groupCount(); i++) {
                Tools.debug("group" + i + ": " + matcher.group(i));
            }
        }
        Tools.debug("result: " + toast);
    }
}
