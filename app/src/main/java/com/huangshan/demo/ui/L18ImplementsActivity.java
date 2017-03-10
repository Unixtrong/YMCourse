package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.AttackSpellCardL18;
import com.huangshan.demo.bean.CardL18;
import com.huangshan.demo.bean.MC;
import com.huangshan.demo.bean.MinionCardL18;
import com.huangshan.demo.bean.SpellCardL18;
import com.huangshan.demo.consts.GlobalConsts;

public class L18ImplementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l18_implements);

        CardL18 card0 = new AttackSpellCardL18("火球术");
        CardL18 card1 = new MinionCardL18("提里奥弗丁");
        AlongCard along = new AlongCard("阿龙");
        along.getCost();
        // 当成员变量与父类中的成员变量同名时，通过谁调用就指的谁的变量
        along.a = 9;

        CardL18[] cards = {card0, card1, along};
        Log.d(GlobalConsts.TAG, "along: " + along.a);

        for (int i = 0; i < cards.length; i++) {
            CardL18 card = cards[i];
            if (card instanceof AttackSpellCardL18) {
                AttackSpellCardL18 asc = (AttackSpellCardL18) card;
                asc.getDamage();
            }
            card.getType();
            card.play();
            Log.d(GlobalConsts.TAG, "card: " + card.a);
        }

        // 接口和类都可以通过匿名内部类的方式构建实例
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();

        MC xmc = new MC() {
        };

        new ListView(this).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    /**
     * 类也可以以内部类的形式存在
     */
    private class AlongCard extends SpellCardL18 {
        public int a = 222;

        public AlongCard(String name) {
            super(name);
        }

        @Override
        public void play() {
            Log.d(GlobalConsts.TAG, "你打出了阿龙");
        }
    }
}
