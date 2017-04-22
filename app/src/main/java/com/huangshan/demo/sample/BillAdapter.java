package com.huangshan.demo.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huangshan.demo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Author(s): danyun
 * Date: 2017/4/21
 */
class BillAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Bill> mData;
    private LayoutInflater mInflater;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:s", Locale.getDefault());

    BillAdapter(Context context, List<Bill> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Bill getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.bill_adapter_item, parent, false);
            holder = new ViewHolder();
            holder.mImageIcon = (ImageView) convertView.findViewById(R.id.bill_iv_icon);
            holder.mTextName = (TextView) convertView.findViewById(R.id.bill_tv_name);
            holder.mTextDate = (TextView) convertView.findViewById(R.id.bill_tv_date);
            holder.mTextMoney = (TextView) convertView.findViewById(R.id.bill_tv_money);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bill bill = mData.get(position);
        holder.mTextName.setText(bill.getName());
        holder.mTextMoney.setText("¥ " + bill.getMoney());
        holder.mImageIcon.setImageResource(bill.getIconId());
        holder.mTextDate.setText(mFormatter.format(new Date(bill.getTimestamp())));


        return convertView;
    }

    private class ViewHolder {
        TextView mTextName;
        ImageView mImageIcon;
        TextView mTextDate;
        TextView mTextMoney;
    }
}
