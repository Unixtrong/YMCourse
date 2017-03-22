package com.huangshan.demo.exercise;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Author(s): danyun
 * Date: 2017/3/22
 */
public class ExcJson {
    public static void hashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "Along");
        map.put("b", "Bian");
        map.put("c", "Cheng");
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject.toString());
    }
}
