package com.huangshan.demo.bean;

import android.util.Log;

import com.huangshan.demo.consts.GlobalConsts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MinionCardL18 extends CardL18 {
    private int damage;
    private int hp;

    public MinionCardL18(String name) {
        setName(name);
    }

    public MinionCardL18(String name, int cost, int damage, int hp) {
        setName(name);
        setCost(cost);
        setDamage(damage);
        setHp(hp);
    }

    public static MinionCardL18 parse(String jsonStr) {
        MinionCardL18 minionCard = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            String name = jsonObject.getString("name");
            int cost = jsonObject.getInt("cost");
            int damage = jsonObject.optInt("damage");
            int hp = jsonObject.getInt("hp");
            minionCard = new MinionCardL18(name, cost, damage, hp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return minionCard;
    }

    public static List<MinionCardL18> parseList(String jsonStr) {
        ArrayList<MinionCardL18> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                MinionCardL18 cardL18 = parse(jsonObject.toString());
                list.add(cardL18);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void play() {
        Log.d(GlobalConsts.TAG, "你打出了一张随从牌");
    }

    public int getHp() {
        return hp;
    }

    public MinionCardL18 setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public String getType() {
        return "随从牌";
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", getName());
            jsonObject.put("cost", getCost());
            jsonObject.put("damage", damage);
            jsonObject.put("hp", hp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
