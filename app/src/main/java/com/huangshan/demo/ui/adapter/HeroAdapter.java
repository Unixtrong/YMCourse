package com.huangshan.demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.HeroBean;

import java.util.List;

/**
 * Author(s): danyun
 * Date: 2017/5/14
 */
public class HeroAdapter extends BaseAdapter {

    private final List<HeroBean> mData;
    private LayoutInflater mInflater;

    public HeroAdapter(Context context, List<HeroBean> data) {
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public HeroBean getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.adapter_hero, parent, false);
            holder.mNameTextView = (TextView) convertView.findViewById(R.id.l37_tv_name);
            holder.mSexTextView = (TextView) convertView.findViewById(R.id.l37_tv_sex);
            holder.mDescTextView = (TextView) convertView.findViewById(R.id.l37_tv_desc);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        HeroBean hero = mData.get(position);
        holder.mNameTextView.setText(hero.getName());
        holder.mDescTextView.setText(hero.getDescription());

        String sex;
        switch (hero.getSex()) {
            case HeroBean.SEX_MALE:
                sex = "男";
                break;
            case HeroBean.SEX_FEMALE:
                sex = "女";
                break;
            case HeroBean.SEX_UNKNOWN:
                sex = "未知";
                break;
            default:
                sex = "未知";
                break;
        }
        holder.mSexTextView.setText(sex);
        return convertView;
    }

    private class Holder {
        TextView mNameTextView;
        TextView mSexTextView;
        TextView mDescTextView;
    }
}
