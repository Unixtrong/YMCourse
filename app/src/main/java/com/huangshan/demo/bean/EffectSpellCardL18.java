package com.huangshan.demo.bean;

import android.util.Log;

import com.huangshan.demo.consts.GlobalConsts;

public class EffectSpellCardL18 extends SpellCardL18 {
    public EffectSpellCardL18(String name) {
        super(name);
    }

    @Override
    public void play() {
        Log.d(GlobalConsts.TAG, "你打出了一张效果法术卡牌");
    }
}
