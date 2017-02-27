package com.huangshan.demo.bean;

public class CardL14 {
    static {
        System.out.println("HS 卡牌 类代码块被调用了");
    }
    // 1. public：任意类中
    // 2. protected：类中、子类中
    // 3. 无：类中、同包下
    // 4. private：仅在类中
    private String name;
    private int cost;
    private String description;

    public CardL14(String name) {
        System.out.println("HS 卡牌 构造方法被调用了");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void setName(String newName) {
        name = newName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int newCost) {
        cost = newCost;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
