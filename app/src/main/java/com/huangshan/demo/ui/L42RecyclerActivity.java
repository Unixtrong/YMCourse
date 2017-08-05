package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huangshan.demo.R;
import com.huangshan.demo.ui.adapter.NameAdapter;

import java.util.ArrayList;
import java.util.List;

public class L42RecyclerActivity extends AppCompatActivity {

    private RecyclerView mNamesRecycler;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l42_recycler);

        mNamesRecycler = (RecyclerView) findViewById(R.id.l42_rv_names);
        mNamesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mData.add("Along");
        mData.add("Adan");
        mData.add("MC");
        mNamesRecycler.setAdapter(new NameAdapter(this, mData));
    }
}
