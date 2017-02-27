package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.AttackSpellCard;

public class L14ExtendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("HS 界面 onCreate 调用开始");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l14_pextents);
        AttackSpellCard card0 = new AttackSpellCard("火球术");
//        MinionCard card1 = new MinionCard("提里奥弗丁");
//        SpellCard card2 = new SpellCard("真言术：韧");
//        CardL14 card3 = new CardL14("血吼");
//        CardL14[] cards = new CardL14[4];
//        cards[0] = card0;
//        cards[1] = card1;
//        cards[2] = card2;
//        cards[3] = card3;
//
//        CardL14 card4 = new AttackSpellCard("");
//
//        for (int i = 0; i < cards.length; i++) {
//            CardL14 card = cards[i];
//            if (card instanceof AttackSpellCard) {
//                AttackSpellCard asc = (AttackSpellCard) card;
//                asc.getDamage();
//            }
//            System.out.println("HS For: " + card.getName());
//        }

        System.out.println("HS 界面 onCreate 调用结束");
        new AlertDialog.Builder(this);
    }
}
