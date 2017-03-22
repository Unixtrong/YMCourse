package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.MinionCardL18;
import com.huangshan.demo.consts.GlobalConsts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class L25JsonActivity extends AppCompatActivity {

    private TextView mTvContent;
    private MinionCardL18 mMinionHulk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l25_json);
        // 1. Object 中的 toString 方法
        // 2. Map 类
        // 3. 一种标准化的数据格式
        mTvContent = (TextView) findViewById(R.id.l25_tv_content);
        mMinionHulk = new MinionCardL18("Hulk", 10, 10, 10);
    }

    public void invokeToString(View view) {
        // 534f8d68
        MinionCardL18 minionThor = new MinionCardL18("Thor", 8, 8, 8);
        MinionCardL18 minionTony = new MinionCardL18("Tony", 7, 7, 7);
        String content = mMinionHulk.toString() + "\n"
                + minionThor.toString() + "\n"
                + minionTony.toString() + "\n";
        mTvContent.setText(content);
    }

    public void invokeMap(View view) {
        HashMap<String, String> cardMap = new HashMap<>();
        cardMap.put("name", "Hulk"); // name -> akhfdlkasdfkjbal
        cardMap.put("cost", "10"); // cost -> akjsdbnlakjbdgakjbg
        cardMap.put("damage", "11");
        cardMap.put("hp", "12");
        String name = cardMap.get("name");

        // 如何便利 Map ?
        // 通过 keySet 方法获取所有 key 的集合
        Set<String> keySet = cardMap.keySet();
        // 通过迭代器便利 keySet
        Iterator<String> iterator = keySet.iterator();
        String content = "cardMap: \n";
        while (iterator.hasNext()) {
            String key = iterator.next();
            // 通过 key 从 map 中获取 value
            content = content + " key: " + key + " value: " + cardMap.get(key) + "\n";
        }
        mTvContent.setText("map size: " + cardMap.size()
                + "\nname: " + name
                + "\nmap: " + cardMap.toString()
                + "\nmap by while: " + content);

        // map 中的其他方法
        cardMap.isEmpty();
        if (cardMap.containsKey("name")) {
            cardMap.get("name");
        }
        if (cardMap.containsValue("Hulk")) {
        }

        // 清空所有键值对
        cardMap.clear();
        cardMap.remove("name");
    }

    private void mcQuestion() {
        String[] keys = "name cost damage hp".split(" ");
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> map = new HashMap<>();
            for (int j = 0; j < keys.length; j++) {
                map.put(keys[j], "randomValue(j)");
            }
        }
    }

    public void buildJson(View view) {
        MinionCardL18 minionThor = new MinionCardL18("Thor", 8, 8, 8);
        MinionCardL18 minionTony = new MinionCardL18("Tony", 7, 7, 7);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(123);
        jsonArray.put("678");
        jsonArray.put(minionThor.toJson());
        jsonArray.put(minionTony.toJson());
        Log.d(GlobalConsts.TAG, jsonArray.toString());
        mTvContent.setText(jsonArray.toString());
    }

    public void parseJson(View view) {
        String jsonStr = "[{\"damage\":8,\"cost\":8,\"hp\":8,\"name\":\"Thor\"},{\"damage\":7,\"cost\":7,\"hp\":7,\"name\":\"Tony\"}]";
        List<MinionCardL18> list = MinionCardL18.parseList(jsonStr);
        mTvContent.setText(Arrays.toString(list.toArray()));
    }
}
