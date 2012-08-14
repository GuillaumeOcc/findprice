package com.siu.multiplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.siu.R;
import com.siu.activity.Echec;
import com.siu.activity.Succes;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 06/08/12
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
public class GameActivityMultiplayer extends Activity {

    private PlayerLabel currentPlayer;

    private Player player1;
    private Player player2;

    private ImageButton button_ok;
    private ImageButton button_one;
    private ImageButton button_two;
    private ImageButton button_three;
    private ImageButton button_four;
    private ImageButton button_five;
    private ImageButton button_six;
    private ImageButton button_seven;
    private ImageButton button_eight;
    private ImageButton button_nine;
    private ImageButton button_zero;
    private ImageButton button_delete;

    private ImageView tropPetit;
    private ImageView tropGrand;
    private ImageView entrerNombre;

    private TextView price;
    private TextView counterText;
    private TextView textPlayer;

    //   private int current_player = 1;

//    private Integer counter;
//    private Integer counterMax;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Bundle extras = getIntent().getExtras();

        entrerNombre = (ImageView) findViewById(R.id.entrer_nombre);
        tropGrand = (ImageView) findViewById(R.id.trop_grand);
        tropPetit = (ImageView) findViewById(R.id.trop_petit);

        price = (TextView) findViewById(R.id.price);
        counterText = (TextView) findViewById(R.id.counter);
        textPlayer = (TextView) findViewById(R.id.text_player);

        button_one = (ImageButton) findViewById(R.id.buttonOne);
        button_two = (ImageButton) findViewById(R.id.buttonTwo);
        button_three = (ImageButton) findViewById(R.id.buttonThree);
        button_four = (ImageButton) findViewById(R.id.buttonFour);
        button_five = (ImageButton) findViewById(R.id.buttonFive);
        button_six = (ImageButton) findViewById(R.id.buttonSix);
        button_seven = (ImageButton) findViewById(R.id.buttonSeven);
        button_eight = (ImageButton) findViewById(R.id.buttonEight);
        button_nine = (ImageButton) findViewById(R.id.buttonNine);
        button_zero = (ImageButton) findViewById(R.id.buttonZero);
        button_delete = (ImageButton) findViewById(R.id.buttonDelete);
        button_ok = (ImageButton) findViewById(R.id.buttonOk);

        player1 = (Player) extras.getSerializable("player1");
        player2 = (Player) extras.getSerializable("player2");

        initButtons();

        counterText.setText("Coups restants : " + MultiGameContext.getInstance().getCounterMax());

        currentPlayer = PlayerLabel.PLAYER1;
        textPlayer.setText("Joueur : 1");
    }

    private void initButtons() {

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 1);
            }
        });

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 2);
            }
        });

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 3);
            }
        });

        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 4);
            }
        });

        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 5);
            }
        });

        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 6);
            }
        });

        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 7);
            }
        });

        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 8);
            }
        });

        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 9);
            }
        });

        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText(price.getText().toString() + 0);
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price.setText("");
            }
        });

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game();
                swap();
            }
        });
    }

    private void game() {
        if(currentPlayer == PlayerLabel.PLAYER1) {
            MultiGameContext.getInstance().incrementCounterPlayer1();
        } else {
            MultiGameContext.getInstance().incrementCounterPlayer2();
            MultiGameContext.getInstance().decrementCounterMax();
        }

        counterText.setText("Coups restants : " + MultiGameContext.getInstance().getCounterMax());

        if (price.getText().length() == 0) {                // regarde s'il y a un nombre,   lenght = taille du texte
            entrerNombre.setVisibility(View.VISIBLE);
            tropGrand.setVisibility(View.GONE);
            tropPetit.setVisibility(View.GONE);
            return;
        }

        int nombre = MultiGameContext.getInstance().getNumber();
         nombre = 49;

        if (nombre == Integer.valueOf(price.getText().toString())) {
            Intent intent = new Intent(GameActivityMultiplayer.this, SuccesMultiActivity.class);
            startActivityForResult(intent, 1);

        } else if (nombre < Integer.valueOf(price.getText().toString())) {
            tropGrand.setVisibility(View.VISIBLE);
            tropPetit.setVisibility(View.GONE);
            entrerNombre.setVisibility(View.GONE);
            price.setText("");
        } else {
            tropPetit.setVisibility(View.VISIBLE);
            tropGrand.setVisibility(View.GONE);
            entrerNombre.setVisibility(View.GONE);
            price.setText("");
        }

        if (MultiGameContext.getInstance().getCounterMax() < 1) {
            Intent intent = new Intent(GameActivityMultiplayer.this, Echec.class);
            startActivity(intent);
        }
    }

    //changer de joueur
    private void swap() {
        if (currentPlayer == PlayerLabel.PLAYER1) {
            currentPlayer = PlayerLabel.PLAYER2;
            textPlayer.setText("Joueur : 2");
        } else {
            currentPlayer = PlayerLabel.PLAYER1;
            textPlayer.setText("Joueur : 1");
        }
    }

    public static enum PlayerLabel {
        PLAYER1, PLAYER2;
    }

}