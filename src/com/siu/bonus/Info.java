package com.siu.bonus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.siu.R;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 31/07/12
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class Info extends Activity {

    private ImageButton buttonLogo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info);


        buttonLogo = (ImageButton) findViewById(R.id.button_logo);


        buttonLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://siu-soon.com/"));
                startActivity(browserIntent);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
      //  EasyTracker.getTracker().trackPageView("/about");
    }
}