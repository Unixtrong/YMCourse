package com.huangshan.demo.bean;

public class MinionCard extends CardL14 {
    private int damage;

    public MinionCard(String name) {
        super(name);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
