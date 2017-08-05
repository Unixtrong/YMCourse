package com.huangshan.demo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huangshan.demo.R;

import java.util.List;

/**
 * Created by danyun on 2017/8/5
 */

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameHolder> {

    private final Context mContext;
    private final List<String> mData;
    private LayoutInflater mInflater;

    public NameAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public NameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NameHolder(mInflater.inflate(R.layout.adapter_l42_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NameHolder holder, int position) {
        String name = mData.get(position);
        holder.nameTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class NameHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;

        NameHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.l42_tv_name);
        }
    }
}
