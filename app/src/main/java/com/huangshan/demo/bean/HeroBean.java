package com.huangshan.demo.bean;

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
public class HeroBean {
    public static final int SEX_MALE = 1;
    public static final int SEX_FEMALE = 2;
    public static final int SEX_UNKNOWN = 3;

    private String mName;
    private int mSex;
    private String mDescription;

    public String getName() {
        return mName;
    }

    public HeroBean setName(String name) {
        mName = name;
        return this;
    }

    public int getSex() {
        return mSex;
    }

    public HeroBean setSex(int sex) {
        mSex = sex;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public HeroBean setDescription(String description) {
        mDescription = description;
        return this;
    }
}
