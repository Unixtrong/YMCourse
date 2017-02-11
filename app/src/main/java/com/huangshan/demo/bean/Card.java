package com.huangshan.demo.bean;

import android.util.Log;

public class Card {
    // 1. public：任意类中
    // 2. protected：类中、子类中
    // 3. 无：类中、同包下
    // 4. private：仅在类中
    public String name = "无名";
    public int cost;
    public String type;
    public int imageId;
    public String description;

    public void play() {
        Log.i("huangshan", "你打出了这张牌");
    }

    public void modifyName() {
        name = "损坏的" + name;
    }
}
