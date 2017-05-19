package com.huangshan.demo.bean;

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
public class HeroBean {
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_UNKNOWN = 3;

    public static final int TEAM_GUARDIAN_OF_GALAXY = 1;
    public static final int TEAM_AVENGERS = 2;

    private String mName;
    private int mGender;
    private int mTeam;
    private String mDescription;

    public HeroBean() {
    }

    public HeroBean(String name, int gender, int team, String description) {
        mName = name;
        mGender = gender;
        mTeam = team;
        mDescription = description;
    }

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

    public int getTeam() {
        return mTeam;
    }

    public HeroBean setTeam(int team) {
        mTeam = team;
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
