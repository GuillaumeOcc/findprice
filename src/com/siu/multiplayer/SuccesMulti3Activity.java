package com.siu.multiplayer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.siu.Global.DatabaseHelper;
import com.siu.R;
import com.siu.activity.MainActivity;
import com.siu.adapter.ScoreAdapterMulti;
import com.siu.model.ScoreMulti;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 13/08/12
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class SuccesMulti3Activity extends Activity {

    private List<ScoreMulti> scoreMulti = new ArrayList<ScoreMulti>();

    private EditText enterName1;
    private EditText enterName2;

    private ListView listScore;
    private ScoreAdapterMulti scoreAdapterMulti;
    private Button button_regame;
    private Button button_main_menu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                                                      setContentView(R.layout.succes_multi3);

        enterName1 = (EditText) findViewById(R.id.enter_name);
        enterName2 = (EditText) findViewById(R.id.enter_name);

        listScore = (ListView) findViewById(R.id.list_score);

        button_regame = (Button) findViewById(R.id.bouton_rejouer);
        button_main_menu = (Button) findViewById(R.id.bouton_menu_principal);

        // Requete sqlite recuperer tous les scores
        SQLiteDatabase db = new DatabaseHelper(this).getWritableDatabase();
        String[] columns = {"name1", "name2"};
        Cursor cursor = db.query("scoresmulti", columns, null, null, null, null, "name1");

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ScoreMulti scoreMulti = new ScoreMulti(cursor.getString(0), cursor.getString(1));
            this.scoreMulti.add(scoreMulti);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

        Log.d(getClass().getName(), "LIST SIZE = " + scoreMulti.size());

        // scoreAdapter.notifyDataSetChanged();  // recharger la listview geree par l'adapter
        scoreAdapterMulti = new ScoreAdapterMulti(SuccesMulti3Activity.this, scoreMulti);
        listScore.setAdapter(scoreAdapterMulti);

        button_regame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccesMulti3Activity.this, GameActivityMultiplayer.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        button_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccesMulti3Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}