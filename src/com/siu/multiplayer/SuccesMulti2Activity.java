package com.siu.multiplayer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.siu.Global.DatabaseHelper;
import com.siu.R;
import com.siu.solitaire.SoloGameContext;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 13/08/12
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public class SuccesMulti2Activity extends Activity {

    private Button valider;

    private EditText enterNamePlayerOne;
    private EditText enterNamePlayerTwo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succes_multi2);

        enterNamePlayerOne = (EditText) findViewById(R.id.enter_name);
        enterNamePlayerTwo = (EditText) findViewById(R.id.enter_name2);

        valider = (Button) findViewById(R.id.button_save_score);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccesMulti2Activity.this, SuccesMulti3Activity.class);
                startActivity(intent);

                ContentValues cv = new ContentValues();
                cv.put("name1", enterNamePlayerOne.getText().toString());
                cv.put("name2", enterNamePlayerTwo.getText().toString());

                SQLiteDatabase db = new DatabaseHelper(SuccesMulti2Activity.this).getWritableDatabase();

                db.insert("scoresmulti", null, cv);
                db.close();
            }
        });
    }
}