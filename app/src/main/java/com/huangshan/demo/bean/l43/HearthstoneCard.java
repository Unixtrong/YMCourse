package com.huangshan.demo.bean.l43;

import com.huangshan.demo.utils.Tools;

/**
 * Created by danyun on 2017/8/6
 */

public class HearthstoneCard {
    private String mName;
    private OnPlayListener mOnPlayListener;

    public String getName() {
        return mName;
    }

    public HearthstoneCard setName(String name) {
        mName = name;
        return this;
    }

    public HearthstoneCard setOnPlayListener(OnPlayListener listener) {
        this.mOnPlayListener = listener;
        return this;
    }

    public void play() {
        if (mOnPlayListener != null) {
            String playResult = mOnPlayListener.onPlay();
            Tools.debug(playResult);
        }
    }

    public interface OnPlayListener {
        String onPlay();
    }
}
