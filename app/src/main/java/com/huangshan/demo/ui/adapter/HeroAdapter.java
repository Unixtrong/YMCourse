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
        return mData.get(position).getDbId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mInflater.inflate(R.layout.adapter_hero, parent, false);
            holder.mNameTextView = (TextView) convertView.findViewById(R.id.l37_tv_name);
            holder.mGenderTextView = (TextView) convertView.findViewById(R.id.l37_tv_gender);
            holder.mTeamTextView = (TextView) convertView.findViewById(R.id.l37_tv_team);
            holder.mDescTextView = (TextView) convertView.findViewById(R.id.l37_tv_desc);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        HeroBean hero = mData.get(position);
        holder.mNameTextView.setText(hero.getName());
        holder.mDescTextView.setText(hero.getDescription());

        String gender;
        switch (hero.getGender()) {
            case HeroBean.GENDER_MALE:
                gender = "男";
                break;
            case HeroBean.GENDER_FEMALE:
                gender = "女";
                break;
            case HeroBean.GENDER_UNKNOWN:
                gender = "未知";
                break;
            default:
                gender = "未知";
                break;
        }
        holder.mGenderTextView.setText(gender);

        String team;
        switch (hero.getTeam()) {
            case HeroBean.TEAM_AVENGERS:
                team = "复仇者联盟";
                break;
            case HeroBean.TEAM_GUARDIAN_OF_GALAXY:
                team = "银河护卫队";
                break;
            default:
                team = "其他";
                break;
        }
        holder.mTeamTextView.setText(team);
        return convertView;
    }

    private class Holder {
        TextView mNameTextView;
        TextView mGenderTextView;
        TextView mTeamTextView;
        TextView mDescTextView;
    }
}
