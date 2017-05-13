package com.huangshan.demo.bean;

import java.util.Random;

/**
 * Author(s): danyun
 * Date: 2017/5/13
 */
public class GameTeam {

    private static final int ROUND_DURATION = 3 * 1000;
    private int mScore;
    private long mStartTime;
    private Random mRandom;
    private int roundTimes;

    public GameTeam() {
        mRandom = new Random();
        mStartTime = System.currentTimeMillis();
    }

    public int getScore() {
        long currentTime = System.currentTimeMillis();
        long interval = currentTime - mStartTime;
        int currentRound = (int) (interval / ROUND_DURATION);
        if (currentRound > roundTimes) {
            roundTimes = currentRound;
            mScore += mRandom.nextInt(3);
        }
        return mScore;
    }

}