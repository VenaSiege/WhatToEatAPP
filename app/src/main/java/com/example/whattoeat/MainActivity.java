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
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    
    private Button whatToEatButton;
    
    private TextView whatToEatText;

    public String[] whatToEatList = {"瓦块烧","漂汤","铁锅炖大鹅","荤豆花","老麻抄手", "刀削面", "兰州拉面", "一食堂", "二食堂", "三食堂", "四食堂", "飘香兔", "寿喜锅", "甜品自助"};

    public Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whatToEatButton = findViewById(R.id.WhatToEatButton);
        whatToEatText = findViewById(R.id.WhatToEat);

        View.OnClickListener clickListener = new ButtonClickListener();

        whatToEatButton.setOnClickListener(clickListener);

//        String[] whatToEatList = {"瓦块烧","漂汤","铁锅炖大鹅","荤豆花","老麻抄手", "刀削面", "兰州拉面", "一食堂", "二食堂", "三食堂", "四食堂", "飘香兔", "寿喜锅", "甜品自助"};
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(final View v) {
            int randomNumber = random.nextInt(whatToEatList.length);

            whatToEatText.setText(whatToEatList[randomNumber]);
        }
    }
}