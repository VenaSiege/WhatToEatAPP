package com.example.whattoeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    
    private Button whatToEatButton;

    private TextView title;
    private TextView whatToEatText;
//    private TextView easterEgg;

    public String[] whatToEatList = {"瓦块烧","漂汤","铁锅炖大鹅","荤豆花","老麻抄手", "刀削面", "兰州拉面", "飘香兔", "寿喜锅", "甜品自助", "土鸡米线", "鸡公煲", "干锅",
                                     "干锅家烤鱼", "西门烤鱼", "冒菜", "王肥肠", "啵啵鱼", "霜霜美蛙鱼", "肥兔公社", "堡！！！"};

    public Calendar calendar = Calendar.getInstance();
    public Random random = new Random();

    public int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    public int clickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whatToEatButton = findViewById(R.id.WhatToEatButton);
        whatToEatText = findViewById(R.id.WhatToEat);
        title = findViewById(R.id.Title);

        View.OnClickListener clickListener = new ButtonClickListener();

        whatToEatButton.setOnClickListener(clickListener);

    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            clickTime = clickTime + 1;

            if(clickTime == 10) {
                title.setText("还没想好？");
            }
            if(clickTime == 20) {
                title.setText("你是真挑啊。");
            }
            if(clickTime == 30) {
                title.setText("还选？莫不是来消遣洒家。");
            }
            if(clickTime == 100) {
                title.setText("你小子别吃了");
                whatToEatButton.setEnabled(false);
            }

            int randomNumber = random.nextInt(whatToEatList.length);
//            whatToEatText.setText(whatToEatList[randomNumber]);

            if(dayOfWeek == 5) {
                String easterEggText = "KFC Crazy Thursday!V me 50 RMB!!";
                if(randomNumber == 4){
                    whatToEatText.setText(easterEggText);
                } else {
                    whatToEatText.setText(whatToEatList[randomNumber]);
                }
            } else {
                whatToEatText.setText(whatToEatList[randomNumber]);
            }
        }
    }
}