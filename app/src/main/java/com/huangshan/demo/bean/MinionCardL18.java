package com.huangshan.demo.bean;

import android.util.Log;

import com.huangshan.demo.consts.GlobalConsts;

public class MinionCardL18 extends CardL18 {
    private int damage;

    public MinionCardL18(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void play() {
        Log.d(GlobalConsts.TAG, "你打出了一张随从牌");
    }

    public String getType() {
        return "随从牌";
    }
}
