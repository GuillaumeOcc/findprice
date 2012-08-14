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
 * Date: 13/08/12
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class SuccesMultiActivity extends Activity {

    private Button buttonOui;
    private Button buttonNon;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.succes_multi);

        buttonOui = (Button) findViewById(R.id.button_oui);


        buttonOui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccesMultiActivity.this, SuccesMulti2Activity.class);
                startActivity(intent);
            }
        });


    }
}