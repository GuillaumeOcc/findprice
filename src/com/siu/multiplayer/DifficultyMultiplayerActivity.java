package com.siu.multiplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.siu.R;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 06/08/12
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class DifficultyMultiplayerActivity extends Activity {

    private Player player1;
    private Player player2;

    private Button buttonEasy;
    private Button buttonNormal;
    private Button buttonHard;
    private Button buttonRandom;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);

        player1 = new Player();
        player2 = new Player();

        buttonEasy = (Button) findViewById(R.id.button_easy);
        buttonNormal = (Button) findViewById(R.id.button_normal);
        buttonHard = (Button) findViewById(R.id.button_hard);

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiGameContext.getInstance().setCounterMax(15);
                start();
            }
        });

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiGameContext.getInstance().setCounterMax(10);
                start();
            }
        });

        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiGameContext.getInstance().setCounterMax(5);
                start();
            }
        });
    }

    private void start() {
        Intent intent = new Intent(DifficultyMultiplayerActivity.this, GameActivityMultiplayer.class);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivityForResult(intent, 1);
    }
}