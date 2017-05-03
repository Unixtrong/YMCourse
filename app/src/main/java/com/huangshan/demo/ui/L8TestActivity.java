package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.Ninja;

public class L8TestActivity extends AppCompatActivity {

    private TextView mTvBattleLog;
    private Button mBtnEnemy;
    private Button mBtnYou;

    private String mBattleLog;
    private int mSelectedId;

    private Ninja mNinjaEnemy;
    private Ninja mNinjaYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l8_test);
        initView();
        initData();
    }

    private void initView() {
        mTvBattleLog = (TextView) findViewById(R.id.l8_test_tv_log);
        mBtnEnemy = (Button) findViewById(R.id.l8_test_btn_enemy);
        mBtnYou = (Button) findViewById(R.id.l8_test_btn_you);
    }

    private void initData() {
        mBattleLog = "战斗日志：";
        mTvBattleLog.setText(mBattleLog);

        mNinjaEnemy = new Ninja().setName("阿迪王").setAttack(20).setHp(20).setId(2);
        mNinjaYou = new Ninja().setName("神小虎").setAttack(5).setHp(25).setId(1);

        mBtnEnemy.setText(formatNinjaInfo(mNinjaEnemy));
        mBtnYou.setText(formatNinjaInfo(mNinjaYou));
    }

    private String formatNinjaInfo(Ninja ninja) {
        if (ninja.getHp() <= 0) {
            return ninja.getName() + " (已阵亡)";
        } else {
            return ninja.getName() + " ( " + ninja.getAttack() + " / " + ninja.getHp() + " )";
        }
    }

    private void toast(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param attacker 攻击者
     * @param attackee 被攻击者
     * @param atkerBtn 攻击者按钮
     * @param atkeeBtn 被攻击者按钮
     */
    private void attack(Ninja attacker, Ninja attackee, Button atkerBtn, Button atkeeBtn) {
        if (attacker.getHp() <= 0) {
            toast(attacker.getName() + "已阵亡");
            return;
        }

        if (attackee.getHp() <= 0) {
            toast(attackee.getName() + "已阵亡");
            return;
        }

        // 计算被攻击者的新生命值
        attackee.setHp(attackee.getHp() - attacker.getAttack());
        // 更新被攻击者的生命值
        atkeeBtn.setText(formatNinjaInfo(attackee));

        // 计算攻击者的新生命值
        attacker.setHp(attacker.getHp() - attackee.getAttack());
        // 更新攻击者的生命值
        atkerBtn.setText(formatNinjaInfo(attacker));

        // 更新日志
        mBattleLog = mBattleLog + makeLog(attacker, attackee);
        mTvBattleLog.setText(mBattleLog);
    }

    private String makeLog(Ninja attacker, Ninja attackee) {
        if (attackee.getHp() <= 0 && attacker.getHp() <= 0) {
            return "\n- 同归于尽。";
        }
        if (attackee.getHp() <= 0) {
            return "\n- " + attackee.getName() + " 已阵亡，"
                    + attacker.getName() + " 获胜，游戏结束。";
        }
        if (attacker.getHp() <= 0) {
            return "\n- " + attacker.getName() + " 已阵亡，"
                    + attacker.getName() + " 失败，游戏结束。";
        }

        return "\n- " + attacker.getName() + " 对 " + attackee.getName()
                + " 造成了 " + attacker.getAttack() + " 点伤害（反伤 "
                + attackee.getAttack() + ")";
    }

    public void clickEnemy(View view) {
        if (mSelectedId == 0) {
            toast("不能控制敌方");
        } else if (mSelectedId == mNinjaYou.getId()) {
            // 战斗
            attack(mNinjaYou, mNinjaEnemy, mBtnYou, mBtnEnemy);
            mSelectedId = 0;
        } else {
            // 可能选择了其他的角色
        }
    }

    public void clickYou(View view) {
        if (mSelectedId == 0) {
            mSelectedId = mNinjaYou.getId();
        } else if (mSelectedId == mNinjaYou.getId()) {
            toast("不能攻击自己");
        } else {
            // 可能选择了其他的 buff
        }
    }
}
