package com.siu.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.siu.R;
import com.siu.adapter.ScoreAdapter;
import com.siu.Global.DatabaseHelper;
import com.siu.model.Score;
import com.siu.solitaire.SoloGameContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 30/07/12
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class Succes extends Activity {

    private Button buttonOui;
    private Button buttonNon;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succes);

        buttonOui = (Button) findViewById(R.id.button_oui);
        buttonNon = (Button) findViewById(R.id.button_non);

        buttonOui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Succes.this, Succes2.class);
                startActivity(intent);
            }
        });

        buttonNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Succes.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // afficher dialog

        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Voulez vous vraiment quitter la partie ?")
                .setCancelable(false)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Succes.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);   //efface l'historique
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}