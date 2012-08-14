package com.siu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.siu.R;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 27/07/12
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class Echec extends Activity {
    private Button buttonRegame;
    private Button buttonMain;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.echec);

        buttonRegame = (Button) findViewById(R.id.button_regame);
        buttonMain   = (Button) findViewById(R.id.button_main);

        buttonRegame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Echec.this, Game.class);
                startActivityForResult(intent, 2);}
        });


        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Echec.this, MainActivity.class);
                startActivityForResult(intent, 2);
            }
        });

    }
}