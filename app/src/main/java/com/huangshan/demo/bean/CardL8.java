package com.huangshan.demo.bean;

public class CardL8 {
    // 1. public：任意类中
    // 2. protected：类中、子类中
    // 3. 无：类中、同包下
    // 4. private：仅在类中
    private String name = "无名";
    private int cost;
    private String type;
    private int imageId;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int newCost) {
        cost = newCost;
    }

    public void setNameAndCost(String newName, int newCost) {
        name = newName;
        cost = newCost;
    }
}
