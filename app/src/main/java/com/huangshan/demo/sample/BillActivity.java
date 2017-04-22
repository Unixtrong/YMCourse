package com.huangshan.demo.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity {

    private TextView mTextRemain;
    private Button mButtonAdd;
    private ListView mListView;
    private List<Bill> mBills = new ArrayList<>();
    private LayoutInflater mInflater;
    private BillAdapter mAdapter;
    private long mRemainMoney = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        initView();
    }

    private void initView() {
        mInflater = LayoutInflater.from(this);
        mTextRemain = (TextView) findViewById(R.id.bill_tv_remain);
        mButtonAdd = (Button) findViewById(R.id.bill_btn_add);
        mListView = (ListView) findViewById(R.id.bill_lv);

        mAdapter = new BillAdapter(this, mBills);
        mListView.setAdapter(mAdapter);
    }

    public void addBill(View view) {
        View contentView = mInflater.inflate(R.layout.bill_dialog_detail, new LinearLayout(this), false);
        final EditText editName = (EditText) contentView.findViewById(R.id.bill_et_name);
        final EditText editMoney = (EditText) contentView.findViewById(R.id.bill_et_money);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("添加一笔消费")
                .setView(contentView)
                .setCancelable(true)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogClickListener(editName, editMoney))
                .create();
        alertDialog.show();
    }

    private class DialogClickListener implements DialogInterface.OnClickListener {

        private final EditText editName;
        private final EditText editMoney;

        DialogClickListener(EditText editName, EditText editMoney) {
            this.editName = editName;
            this.editMoney = editMoney;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String name = editName.getText().toString();
            String moneyStr = editMoney.getText().toString();
            long time = System.currentTimeMillis();
            int iconId = R.mipmap.ic_hearthstone_minion;
            int money = Tools.toInteger(moneyStr);
            Bill bill = new Bill(name, money, time, iconId);
            mBills.add(bill);
            mAdapter.notifyDataSetChanged();

            mRemainMoney = mRemainMoney - money;
            mTextRemain.setText("¥" + mRemainMoney);
        }
    }
}
