package com.example.pokerprobablitygenerator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Input_poker_3 extends AppCompatActivity {
    TextView display;
    ImageButton spades;
    ImageButton clubs;
    ImageButton hearts;
    ImageButton diamonds;
    Spinner spinner;
    int spades_cnt;
    int diamonds_cnt;
    int hearts_cnt;
    int clubs_cnt;
    int number[];
    Card player_hand[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_poker_3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        display = (TextView) findViewById(R.id.display);
        spades = (ImageButton) findViewById(R.id.spadez);
        clubs = (ImageButton) findViewById(R.id.clubz);
        hearts = (ImageButton) findViewById(R.id.heartz);
        diamonds = (ImageButton) findViewById(R.id.diamondz);
        Button button = (Button) findViewById(R.id.button2);
        spinner = (Spinner) findViewById(R.id.spinner);
        Intent intent = getIntent();
        player_hand = new Card[7];
        for (int i = 0; i < 5; i++) {
            player_hand[i] =  intent.getParcelableExtra("player's hand" + i);

        }
        String rank[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "KING", "QUEEN", "ACE"};
        number = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ArrayAdapter<String> face_value = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rank);
        face_value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(face_value);
        display.setText("Player," + " Enter Final Card " );
        spades_cnt = 1;
        spades.setBackgroundColor(Color.parseColor("#24F53C"));
        spades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spades_cnt++;
                clubs_cnt=0;
                hearts_cnt=0;
                diamonds_cnt=0;
                diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                hearts.setBackgroundColor(Color.parseColor("#00000000"));
                clubs.setBackgroundColor(Color.parseColor("#00000000"));
                if(spades_cnt>0) {
                    spades.setBackgroundColor(Color.parseColor("#24F53C"));
                }
                else
                    spades.setBackgroundColor(Color.parseColor("#00000000"));
            }
        });
        clubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spades_cnt=0;
                clubs_cnt++;
                hearts_cnt=0;
                diamonds_cnt=0;
                diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                hearts.setBackgroundColor(Color.parseColor("#00000000"));
                spades.setBackgroundColor(Color.parseColor("#00000000"));
                if(clubs_cnt>0){
                    clubs.setBackgroundColor(Color.parseColor("#24F53C"));
                }
                else
                    clubs.setBackgroundColor(Color.parseColor("#00000000"));
            }
        });

        hearts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tag check::","i am clicked on hearts");
                spades_cnt=0;
                clubs_cnt=0;
                hearts_cnt++;
                diamonds_cnt=0;
                diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                spades.setBackgroundColor(Color.parseColor("#00000000"));
                clubs.setBackgroundColor(Color.parseColor("#00000000"));
                if(hearts_cnt>0) {
                    hearts.setBackgroundColor(Color.parseColor("#24F53C"));
                }
                else
                    hearts.setBackgroundColor(Color.parseColor("#00000000"));

            }
        });
        diamonds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spades_cnt=0;
                clubs_cnt=0;
                hearts_cnt=0;
                diamonds_cnt++;
                spades.setBackgroundColor(Color.parseColor("#00000000"));
                hearts.setBackgroundColor(Color.parseColor("#00000000"));
                clubs.setBackgroundColor(Color.parseColor("#00000000"));
                if(diamonds_cnt>0) {
                    diamonds.setBackgroundColor(Color.parseColor("#24F53C"));
                }
                else
                    diamonds.setBackgroundColor(Color.parseColor("#00000000"));

            }
        });

        Log.d("Counts are ", "Values are :: " + spades_cnt + "::" + clubs_cnt + "::" + diamonds_cnt + "::" + hearts_cnt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spades_cnt >0  ) {
                    player_hand[5]= new Card(number[spinner.getSelectedItemPosition()],"spades") ;
                }
                else if(clubs_cnt >0 ) {
                    player_hand[5]= new Card(number[spinner.getSelectedItemPosition()],"clubs") ;
                }
                else if(diamonds_cnt >0) {
                    player_hand[5]= new Card(number[spinner.getSelectedItemPosition()],"diamonds") ;
                }
                else if(hearts_cnt >0) {
                    player_hand[5]= new Card(number[spinner.getSelectedItemPosition()],"hearts") ;
                }
                Intent intent;
                intent = new Intent(Input_poker_3.this, Input_poker_4.class);
                for (int i = 0; i < player_hand.length; i++) {
                    Log.d("Poker3::", "hand for " + i + " = " + player_hand[i]);
                    intent.putExtra("player's hand" + i, player_hand[i]);

                }
                startActivity(intent);
            }
        });

    }
}
