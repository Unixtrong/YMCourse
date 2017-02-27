package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.huangshan.demo.R;

public class L11ListViewActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l11_list_view);

        // 1. 从布局中加载 ListView
        mListView = (ListView) findViewById(R.id.l11_lv);

        // 2. 准备需要展示的数据
        String[] nameArray = new String[1000];
        for (int i = 0; i < nameArray.length; i = i + 1) {
            nameArray[i] = "阿龙" + i + "号";
        }

        // 3. 将数据绑定到 Adapter 上
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, nameArray);

        // 4. 为 ListView 设置 Adapter
        mListView.setAdapter(arrayAdapter);

        // 5. 为 ListView 添加点击事件
        mListView.setOnItemClickListener(new OnNameClickListener());
    }

    class OnNameClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String name = (String) adapterView.getItemAtPosition(position);
            String content = name + " - " + position;
            Toast.makeText(L11ListViewActivity.this, content, Toast.LENGTH_SHORT).show();
        }
    }
}
