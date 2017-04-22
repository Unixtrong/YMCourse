package com.huangshan.demo.sample;

/**
 * Author(s): danyun
 * Date: 2017/4/21
 */
class Bill {
    private String mName;
    private int mMoney;
    private long mTimestamp;
    private int mIconId;

    Bill(String name, int money, long timestamp, int iconId) {
        mName = name;
        mMoney = money;
        mTimestamp = timestamp;
        mIconId = iconId;
    }

    public String getName() {
        return mName;
    }

    public Bill setName(String name) {
        mName = name;
        return this;
    }

    public int getMoney() {
        return mMoney;
    }

    public Bill setMoney(int money) {
        mMoney = money;
        return this;
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public Bill setTimestamp(long timestamp) {
        mTimestamp = timestamp;
        return this;
    }

    public int getIconId() {
        return mIconId;
    }

    public Bill setIconId(int iconId) {
        mIconId = iconId;
        return this;
    }
}
