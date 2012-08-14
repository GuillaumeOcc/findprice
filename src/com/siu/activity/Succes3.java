package com.siu.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.siu.Global.DatabaseHelper;
import com.siu.R;
import com.siu.adapter.ScoreAdapter;
import com.siu.model.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 31/07/12
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class Succes3 extends Activity {

    private List<Score> scores = new ArrayList<Score>();

    private EditText enterName;

    private ListView listScore;
    private ScoreAdapter scoreAdapter;
    private Button buttonRejouer;
    private Button buttonMainMenu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succes3);

        listScore = (ListView) findViewById(R.id.list_score);
        enterName = (EditText) findViewById(R.id.enter_name);
        buttonRejouer = (Button) findViewById(R.id.bouton_rejouer);
        buttonMainMenu = (Button) findViewById(R.id.bouton_menu_principal);

        // Requete sqlite recuperer tous les scores
        SQLiteDatabase db = new DatabaseHelper(this).getWritableDatabase();
        String[] columns = {"score", "name"};
        Cursor cursor = db.query("scores", columns, null, null, null, null, "score");

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Score score = new Score(cursor.getString(1), cursor.getInt(0));
            scores.add(score);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        Log.d(getClass().getName(), "LIST SIZE = " + scores.size());

        // scoreAdapter.notifyDataSetChanged();  // recharger la listview geree par l'adapter
        scoreAdapter = new ScoreAdapter(Succes3.this, scores);
        listScore.setAdapter(scoreAdapter);

        buttonRejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Succes3.this, Game.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Succes3.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}