package com.huangshan.demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.l43.HearthstoneCard;

public class L43ListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l43_listener);

        String along = "";
        String mc = along;
        along = "along";
        System.out.println("along: " + mc);
    }

    public void play(View view) {
        Neptulon neptulon = new Neptulon();
        neptulon.setOnPlayListener(new HearthstoneCard.OnPlayListener() {
            @Override
            public String onPlay() {
                return "随机置入4鱼";
            }
        });

        neptulon.play();
    }

    private class Neptulon extends HearthstoneCard {
    }
}
