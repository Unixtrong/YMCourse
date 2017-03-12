package com.huangshan.demo.bean;

import android.util.Log;

import com.huangshan.demo.consts.GlobalConsts;

public class MinionCardL18 extends CardL18 {
    private int damage;
    private int hp;

    public MinionCardL18(String name) {
        setName(name);
    }

    public MinionCardL18(String name, int cost, int damage, int hp) {
        setName(name);
        setCost(cost);
        setDamage(damage);
        setHp(hp);
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

    public int getHp() {
        return hp;
    }

    public MinionCardL18 setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public String getType() {
        return "随从牌";
    }
}
