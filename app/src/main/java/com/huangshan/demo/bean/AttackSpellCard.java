package com.huangshan.demo.bean;

public class AttackSpellCard extends SpellCard {
    static {
        System.out.println("HS 攻击法术卡牌 类代码块被调用了");
    }

    private int damage;

    public AttackSpellCard(String name) {
        super(name);
        System.out.println("HS 攻击法术卡牌 构造方法被调用了");
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
