package com.huangshan.demo.bean;

public class SpellCard extends CardL14 {
    static {
        System.out.println("HS 法术卡牌 类代码块被调用了");
    }

    public SpellCard(String name) {
        super(name);
        System.out.println("HS 法术卡牌 构造方法被调用了");
    }

    private void play() {
    }
}
