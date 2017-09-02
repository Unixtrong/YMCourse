package com.huangshan.demo.bean;

import java.io.Serializable;

public abstract class CardL18 implements Serializable {
    public final int a = 9;
    // 1. public：任意类中
    // 2. protected：类中、子类中
    // 3. 无：类中、同包下
    // 4. private：仅在类中
    private String name;
    private int cost;
    private String description;

    public String getName() {
        return name;
    }

    protected void setName(String newName) {
        name = newName;
    }

    public final int getCost() {
        return cost;
    }

    public void setCost(int newCost) {
        cost = newCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(int description) {
        // ...
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void play();

    public abstract String getType();

    @Override
    public String toString() {
        return "CardL18 { name: " + name + " cost: " + getCost() + "}";
    }
}
