package com.siu.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.siu.Global.DatabaseHelper;
import com.siu.R;
import com.siu.adapter.ScoreAdapter;
import com.siu.model.Score;
import com.siu.solitaire.SoloGameContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 27/07/12
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class Succes2 extends Activity {

    private Button boutonValider;
    private EditText enterName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succes2);

        boutonValider = (Button) findViewById(R.id.button_save_score);
        enterName = (EditText) findViewById(R.id.enter_name);

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (enterName.getText().length() == 0) {

                    Toast.makeText(Succes2.this, "Ecrivez un nom !", 200000).show();
                } else {
                    Intent intent = new Intent(Succes2.this, Succes3.class);
                    startActivityForResult(intent, 1);

                    ContentValues cv = new ContentValues();
                    cv.put("name", enterName.getText().toString());
                    cv.put("score", SoloGameContext.getInstance().getCounter());

                    SQLiteDatabase db = new DatabaseHelper(Succes2.this).getWritableDatabase();

                    db.insert("scores", null, cv);
                    db.close();
                }
            }


        });


    }
}