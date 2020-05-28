package com.example.pokerprobablitygenerator;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
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

public class Input_poker extends AppCompatActivity {
     int cnt = 0;
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
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_poker);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
         display = (TextView) findViewById(R.id.display);
         error = (TextView)findViewById(R.id.textView2) ;
         spades = (ImageButton) findViewById(R.id.spadez);
         clubs = (ImageButton) findViewById(R.id.clubz);
         hearts = (ImageButton) findViewById(R.id.heartz);
        diamonds = (ImageButton) findViewById(R.id.diamondz);
        Button button = (Button) findViewById(R.id.button2);
         spinner = (Spinner) findViewById(R.id.spinner);
         player_hand = new Card[5];
        String rank[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "KING", "QUEEN", "ACE"};
        number = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ArrayAdapter<String> face_value = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rank);
        face_value.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(face_value);
        display.setText("Player," + " Enter Card " + (cnt+1) );
        spades.setBackgroundColor(Color.parseColor("#24F53C"));
        spades_cnt = 1;
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
              if(spades_cnt>0)
              spades.setBackgroundColor(Color.parseColor("#24F53C"));
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
                if(clubs_cnt>0)
                    clubs.setBackgroundColor(Color.parseColor("#24F53C"));
                else
                    clubs.setBackgroundColor(Color.parseColor("#00000000"));
                Log.i("sup", clubs_cnt+"");
            }
        });
        Log.i("sup2", clubs_cnt+"");
        hearts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spades_cnt=0;
                clubs_cnt=0;
                hearts_cnt++;
                diamonds_cnt=0;
                diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                spades.setBackgroundColor(Color.parseColor("#00000000"));
                clubs.setBackgroundColor(Color.parseColor("#00000000"));
                if(hearts_cnt>0)
                    hearts.setBackgroundColor(Color.parseColor("#24F53C"));
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
                if(diamonds_cnt>0)
                    diamonds.setBackgroundColor(Color.parseColor("#24F53C"));
                else
                    diamonds.setBackgroundColor(Color.parseColor("#00000000"));

            }
        });
        if(spades_cnt >0  ) {
            player_hand[0]= new Card(number[spinner.getSelectedItemPosition()],"spades") ;
        }
        else if(clubs_cnt >0 ) {
            player_hand[0]= new Card(number[spinner.getSelectedItemPosition()],"clubs") ;
        }
        else if(diamonds_cnt >0) {
            player_hand[0]= new Card(number[spinner.getSelectedItemPosition()],"diamonds") ;
        }
        else if(hearts_cnt >0) {
            player_hand[0]= new Card(number[spinner.getSelectedItemPosition()],"hearts") ;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt==1)
                    display.setText("Player, Enter Card " + "2");
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
                        if(spades_cnt>0)
                            spades.setBackgroundColor(Color.parseColor("#24F53C"));
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
                        if(clubs_cnt>0)
                            clubs.setBackgroundColor(Color.parseColor("#24F53C"));
                        else
                            clubs.setBackgroundColor(Color.parseColor("#00000000"));
                    }
                });
                hearts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spades_cnt=0;
                        clubs_cnt=0;
                        hearts_cnt++;
                        diamonds_cnt=0;
                        diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                        spades.setBackgroundColor(Color.parseColor("#00000000"));
                        clubs.setBackgroundColor(Color.parseColor("#00000000"));
                        if(hearts_cnt>0)
                            hearts.setBackgroundColor(Color.parseColor("#24F53C"));
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
                        if(diamonds_cnt>0)
                            diamonds.setBackgroundColor(Color.parseColor("#24F53C"));
                        else
                            diamonds.setBackgroundColor(Color.parseColor("#00000000"));

                    }
                });

                  if(cnt==2 || cnt==3 || cnt ==4) {
                      display.setText("Player, Enter dealt card" + (cnt - 1));
                      spades.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              spades_cnt++;
                              clubs_cnt = 0;
                              hearts_cnt = 0;
                              diamonds_cnt = 0;
                              diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                              hearts.setBackgroundColor(Color.parseColor("#00000000"));
                              clubs.setBackgroundColor(Color.parseColor("#00000000"));
                              if (spades_cnt > 0)
                                  spades.setBackgroundColor(Color.parseColor("#24F53C"));
                              else
                                  spades.setBackgroundColor(Color.parseColor("#00000000"));
                          }
                      });
                      clubs.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              spades_cnt = 0;
                              clubs_cnt++;
                              hearts_cnt = 0;
                              diamonds_cnt = 0;
                              diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                              hearts.setBackgroundColor(Color.parseColor("#00000000"));
                              spades.setBackgroundColor(Color.parseColor("#00000000"));
                              if (clubs_cnt >0)
                                  clubs.setBackgroundColor(Color.parseColor("#24F53C"));
                              else
                                  clubs.setBackgroundColor(Color.parseColor("#00000000"));
                          }
                      });
                      hearts.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              spades_cnt = 0;
                              clubs_cnt = 0;
                              hearts_cnt++;
                              diamonds_cnt = 0;
                              diamonds.setBackgroundColor(Color.parseColor("#00000000"));
                              spades.setBackgroundColor(Color.parseColor("#00000000"));
                              clubs.setBackgroundColor(Color.parseColor("#00000000"));
                              if (hearts_cnt >0)
                                  hearts.setBackgroundColor(Color.parseColor("#24F53C"));
                              else
                                  hearts.setBackgroundColor(Color.parseColor("#00000000"));

                          }
                      });
                      diamonds.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              spades_cnt = 0;
                              clubs_cnt = 0;
                              hearts_cnt = 0;
                              diamonds_cnt++;
                              spades.setBackgroundColor(Color.parseColor("#00000000"));
                              hearts.setBackgroundColor(Color.parseColor("#00000000"));
                              clubs.setBackgroundColor(Color.parseColor("#00000000"));
                              if (diamonds_cnt >0)
                                  diamonds.setBackgroundColor(Color.parseColor("#24F53C"));
                              else
                                  diamonds.setBackgroundColor(Color.parseColor("#00000000"));

                          }
                      });
                  }
                if(spades_cnt >0 ) {
                    player_hand[cnt-1]= new Card(number[spinner.getSelectedItemPosition()],"spades") ;
                }
                else if(clubs_cnt>0) {
                    player_hand[cnt-1]= new Card(number[spinner.getSelectedItemPosition()],"clubs") ;
                }
                else if(diamonds_cnt>0 ) {
                    player_hand[cnt-1]= new Card(number[spinner.getSelectedItemPosition()],"diamonds") ;
                }
                else if(hearts_cnt>0 ) {
                    player_hand[cnt-1]= new Card(number[spinner.getSelectedItemPosition()],"hearts") ;
                }
                else
                    player_hand[cnt-1]= new Card(number[spinner.getSelectedItemPosition()],"spades") ;
                if(cnt >=5) {
                    Intent intent;
                    intent = new Intent(Input_poker.this, input_poker_2.class);
                     for (int i = 0; i < player_hand.length; i++) {
                        intent.putExtra("player's hand" + i, player_hand[i]);

                    }
                    startActivity(intent);
                }
            }

        });

    }

}

