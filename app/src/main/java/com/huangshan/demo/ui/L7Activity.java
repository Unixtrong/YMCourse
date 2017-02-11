package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.huangshan.demo.R;
import com.huangshan.demo.bean.Card;

public class L7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l7);
    }

    public void onClick(View view) {
        Card card1 = new Card();
        card1.name = "百变泽鲁斯";
        card1.cost = 1;
        card1.type = "minion"; // spell
        card1.description = "每回合变成一张随机随从牌。";
        card1.imageId = R.mipmap.image_first;
        String cardInfo =
                "牌名：" + card1.name
                + "\n费用：" + card1.cost
                + "\n类型：" + card1.type
                + "\n描述：" + card1.description;
        Toast.makeText(this, cardInfo, Toast.LENGTH_LONG).show();

        ImageView ivCard = (ImageView) findViewById(R.id.l7_iv_card);
        ivCard.setImageResource(card1.imageId);
    }
}
