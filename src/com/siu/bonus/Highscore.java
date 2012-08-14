package com.siu.bonus;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.siu.Global.DatabaseHelper;
import com.siu.R;
import com.siu.adapter.ScoreAdapter;
import com.siu.adapter.ScoreAdapterMulti;
import com.siu.model.Score;
import com.siu.model.ScoreMulti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 30/07/12
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class Highscore extends Activity {

    private Button button_highscore_solitaire;
    private Button button_highscore_multijoueur;

    private ListView listScore;
    private ListView listScoreMulti;

    private List<Score> scores = new ArrayList<Score>();
    private ScoreAdapter scoreAdapter;

    private List<ScoreMulti> scoremulti = new ArrayList<ScoreMulti>();
    private ScoreAdapterMulti scoreAdapterMulti;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        button_highscore_solitaire = (Button) findViewById(R.id.button_highscore_solitaire);
        button_highscore_multijoueur = (Button) findViewById(R.id.button_highscore_multijoueur);


        listScore = (ListView) findViewById(R.id.list_score);
        listScoreMulti = (ListView) findViewById(R.id.list_score_multi);

        getSoloScores();
        getMultiScores();

        scoreAdapter = new ScoreAdapter(this, scores);
        scoreAdapterMulti = new ScoreAdapterMulti(this, scoremulti);

        // liste sera rempli de scores

        button_highscore_solitaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_highscore_solitaire.setVisibility(View.GONE);
                button_highscore_multijoueur.setVisibility(View.VISIBLE);
                listScore.setAdapter(scoreAdapter);
            }
        });

        button_highscore_multijoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listScore.setAdapter(scoreAdapterMulti);
                button_highscore_multijoueur.setVisibility(View.GONE);
                button_highscore_solitaire.setVisibility(View.VISIBLE);
            }
        });
        // liste sera remplie de scores multi
    }

    public void getSoloScores() {
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
    }

    public void getMultiScores() {

        // Requete sqlite recuperer tous les scores
        SQLiteDatabase db = new DatabaseHelper(this).getWritableDatabase();
        String[] columns = {"name1", "name2"};
        Cursor cursor = db.query("scoresmulti", columns, null, null, null, null, "name1");

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ScoreMulti scoreMulti = new ScoreMulti(cursor.getString(0), cursor.getString(1));
            scoremulti.add(scoreMulti);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        Log.d(getClass().getName(), "LIST SIZE = " + scoremulti.size());

    }
}