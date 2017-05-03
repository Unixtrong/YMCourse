package com.huangshan.demo.bean;

public class Ninja {
    private int mId;
    private String mName;
    private int mAttack;
    private int mHp;

    public int getId() {
        return mId;
    }

    public Ninja setId(int id) {
        mId = id;
        return this;
    }

    public String getName() {
        return mName;
    }

    public Ninja setName(String name) {
        mName = name;
        return this;
    }

    public int getAttack() {
        return mAttack;
    }

    public Ninja setAttack(int attack) {
        mAttack = attack;
        return this;
    }

    public int getHp() {
        return mHp;
    }

    public Ninja setHp(int hp) {
        mHp = hp;
        return this;
    }
}
