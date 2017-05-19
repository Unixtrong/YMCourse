package com.huangshan.demo.bean;

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
public class HeroBean {
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_UNKNOWN = 3;

    private String mName;
    private int mGender;
    private String mDescription;

    public String getName() {
        return mName;
    }

    public HeroBean setName(String name) {
        mName = name;
        return this;
    }

    public int getGender() {
        return mGender;
    }

    public HeroBean setGender(int gender) {
        mGender = gender;
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
