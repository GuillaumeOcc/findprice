package com.siu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.siu.R;
import com.siu.bonus.Highscore;
import com.siu.bonus.Info;
import com.siu.multiplayer.DifficultyMultiplayerActivity;

public class MainActivity extends Activity {

    private Button buttonSolitaire;
    private Button buttonMultiplayer;
    private Button buttonScore;
    private Button buttonInfo;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonSolitaire = (Button) findViewById(R.id.button_solitaire);
        buttonMultiplayer = (Button) findViewById(R.id.button_multiplayer);
        buttonScore = (Button) findViewById(R.id.button_scores);
        buttonInfo = (Button) findViewById(R.id.button_info);

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Info.class);
                startActivity(intent);
            }
        });

        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Highscore.class);
                startActivity(intent);
            }
        });

        buttonSolitaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Difficulty.class);
                startActivityForResult(intent, 1);
            }
        });

        buttonMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DifficultyMultiplayerActivity.class);
                startActivityForResult(intent, 2);
            }
        });







   }
}
