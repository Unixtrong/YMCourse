package com.huangshan.demo.bean;

import android.util.Log;

import com.huangshan.demo.consts.GlobalConsts;

public class AttackSpellCardL18 extends SpellCardL18 {
    static {
        System.out.println("HS 攻击法术卡牌 类代码块被调用了");
    }

    private int damage;

    public AttackSpellCardL18(String name) {
        super(name);
        System.out.println("HS 攻击法术卡牌 构造方法被调用了");
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void play() {
        Log.d(GlobalConsts.TAG, "你打出了一张攻击法术卡牌");
    }
}
