package com.huangshan.demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.AttackSpellCardL18;
import com.huangshan.demo.bean.CardL18;
import com.huangshan.demo.bean.MinionCardL18;
import com.huangshan.demo.bean.SpellCardL18;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<CardL18> mData;

    /**
     * 通过构造方法传入 context 和数据集合
     */
    public CardAdapter(Context context, ArrayList<CardL18> data) {
        mContext = context;
        mData = data;
    }

    /**
     * 数据集合内对象的数量
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 获取一个数据对象
     */
    @Override
    public CardL18 getItem(int position) {
        return mData.get(position);
    }

    /**
     * 获取数据对象的ID
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取某一项的子视图
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        Holder holder;
        if (view == null) {
            // 该类型的布局第一次出现在界面上
            view = inflater.inflate(R.layout.adapter_card, viewGroup, false);
            holder = new Holder();
            holder.mIvIcon = (ImageView) view.findViewById(R.id.l20_iv_icon);
            holder.mTvName = (TextView) view.findViewById(R.id.l20_tv_name);
            holder.mTvAttack = (TextView) view.findViewById(R.id.l20_tv_attack);
            holder.mTvCost = (TextView) view.findViewById(R.id.l20_tv_cost);
            holder.mTvHp = (TextView) view.findViewById(R.id.l20_tv_hp);
            // 把填好控件的 holder 放入控件的 tag 中
            view.setTag(holder);
        } else {
            // 从控件的 tag 中加载 holder
            holder = (Holder) view.getTag();
        }

        // 通过索引从数据集合中获取数据对象
        CardL18 card = mData.get(position);
        holder.mTvName.setText(card.getName());
        holder.mTvCost.setText("费：" + card.getCost());
        // instanceof: instance of
        if (card instanceof SpellCardL18) {
            holder.mIvIcon.setImageResource(R.mipmap.ic_hearthstone);
            holder.mTvHp.setText("");
            if (card instanceof AttackSpellCardL18) {
                AttackSpellCardL18 asc = (AttackSpellCardL18) card;
                holder.mTvAttack.setText("攻：" + asc.getDamage());
            } else {
                holder.mTvAttack.setText("");
            }
        } else if (card instanceof MinionCardL18) {
            MinionCardL18 minion = (MinionCardL18) card;
            holder.mTvAttack.setText("攻：" + minion.getDamage());
            holder.mTvHp.setText("血：" + minion.getHp());
            holder.mIvIcon.setImageResource(R.mipmap.ic_hearthstone_minion);
        } else {
            // 没用到的控件必须清空数据
            holder.mTvAttack.setText("");
            holder.mTvHp.setText("");
            holder.mIvIcon.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }

    private class Holder {
        ImageView mIvIcon;
        TextView mTvName;
        TextView mTvCost;
        TextView mTvAttack;
        TextView mTvHp;
    }
}
