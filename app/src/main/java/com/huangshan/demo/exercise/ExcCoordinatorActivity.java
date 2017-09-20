package com.huangshan.demo.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huangshan.demo.R;

public class ExcCoordinatorActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exc_coodinator);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.exc_rv);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        private LayoutInflater mInflater = LayoutInflater.from(ExcCoordinatorActivity.this);

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(mInflater.inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.bind("Along sapi!");
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        void bind(String name) {
            mTextView.setText(name);
        }
    }

}
