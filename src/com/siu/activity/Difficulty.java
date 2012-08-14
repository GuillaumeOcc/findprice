package com.siu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.siu.R;
import com.siu.solitaire.SoloGameContext;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 17/07/12
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public class Difficulty extends Activity {

    private Button buttonEasy;
    private Button buttonNormal;
    private Button buttonHard;
    private Button buttonRandom;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);

        buttonEasy = (Button) findViewById(R.id.button_easy);
        buttonNormal = (Button) findViewById(R.id.button_normal);
        buttonHard = (Button) findViewById(R.id.button_hard);

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoloGameContext.getInstance().setCounterMax(15);
                start();
            }
        });

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoloGameContext.getInstance().setCounterMax(10);
                start();
            }
        });

        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoloGameContext.getInstance().setCounterMax(5);
                start();
            }
        });
}

    private void start() {
        Intent intent = new Intent(Difficulty.this, Game.class);
        startActivityForResult(intent, 1);
    }
}