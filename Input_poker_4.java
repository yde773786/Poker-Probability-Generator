package com.example.pokerprobablitygenerator;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Input_poker_4 extends AppCompatActivity {
    TextView display_hand, strflu, four, flu, fh, str, p, twop, three, current_hand;
    Button reset;
    Card player_hand[];
    Card probability_player_hand[];
    int str_flush_cnt, four_cnt, fh_cnt, flush_cnt, str_cnt, three_cnt, twopair_cnt, pair_cnt;
    double str_flush_pro, four_pro, fh_pro, flush_pro, str_pro, three_pro, twopair_pro, pair_pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_poker_4);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        reset = (Button)findViewById(R.id.reset) ;
        display_hand = (TextView) findViewById(R.id.display_hand);
        current_hand = (TextView) findViewById(R.id.current_hand);
        strflu = (TextView) findViewById(R.id.strflu);
        four = (TextView) findViewById(R.id.four);
        fh = (TextView) findViewById(R.id.fh);
        three = (TextView) findViewById(R.id.three);
        twop = (TextView) findViewById(R.id.twop);
        p = (TextView) findViewById(R.id.p);
        str = (TextView) findViewById(R.id.str);
        flu = (TextView) findViewById(R.id.flu);
        player_hand = new Card[6];
        Intent intent = getIntent();
        for (int i = 0; i < 6; i++) {
            player_hand[i] = intent.getParcelableExtra("player's hand" + i);

        }
        String y = "Highest hand Probability Generator (Final round)";
        display_hand.setText(y);
        if (!Card.check_hand(player_hand).equals("WRONG INPUT")) {
            String b = "YOUR HAND IS: " + Card.check_hand(player_hand);
            current_hand.setText(b);
            probability_player_hand = new Card[7];
            for (int i = 0; i < 6; i++) {
                probability_player_hand[i] = player_hand[i];
            }
            String suit[] = {"spades", "clubs", "diamonds", "hearts"};
            int number[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
            int probability_suit_changer = 0;
            int cnt = 1;
            String probability_suit = "spades";
            int probability_number = -1;
            for (int i = 1; i <= 52; i++) {
                if (cnt == 14) {
                    cnt = 1;
                    probability_suit = suit[++probability_suit_changer];
                    probability_number = -1;
                }
                probability_number++;
                probability_player_hand[6] = new Card(number[probability_number], probability_suit);
                String s = Card.check_hand(probability_player_hand);
                if (s.equals("STRAIGHT FLUSH"))
                    str_flush_cnt++;
                else if (s.equals("FOUR OF A KIND"))
                    four_cnt++;
                else if (s.equals("FULL HOUSE"))
                    fh_cnt++;
                else if (s.equals("FLUSH"))
                    flush_cnt++;
                else if (s.equals("STRAIGHT"))
                    str_cnt++;
                else if (s.equals("THREE OF A KIND"))
                    three_cnt++;
                else if (s.equals("TWO PAIR"))
                    twopair_cnt++;
                else if (s.equals("PAIR"))
                    pair_cnt++;
                cnt++;


            }
            str_flush_pro = (str_flush_cnt/46.0)*100;
            four_pro = (four_cnt/46.0)*100;
            fh_pro = (fh_cnt/46.0)*100;
            flush_pro = (flush_cnt/46.0)*100;
            str_pro = (str_cnt/46.0)*100;
            three_pro = (three_cnt/46.0)*100;
            pair_pro = (pair_cnt/46.0)*100;
            twopair_pro = (twopair_cnt/46.0)*100;
            three.setText(approx(three_pro)+"%");
            p.setText(approx(pair_pro)+"%");
            twop.setText(approx(twopair_pro)+"%");
            four.setText(approx(four_pro)+"%");
            flu.setText(approx(flush_pro)+"%");
            str.setText(approx(str_pro)+"%");
            fh.setText(approx(fh_pro)+"%");
            strflu.setText(approx(str_flush_pro)+"%");
        }
        else {
            String b = "WRONG INPUT, TRY AGAIN.";
            String x = "-";
            current_hand.setText(b);
            three.setText(x);
            p.setText(x);
            twop.setText(x);
            four.setText(x);
            flu.setText(x);
            str.setText(x);
            fh.setText(x);
            strflu.setText(x);


        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Input_poker_4.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void onBackPressed()

    {
        Intent intent = new Intent(this, Input_poker_3.class);
        startActivity(intent);
        finish();
    }
    public double approx(double x) {
        x *= 100 ;
        x = Math.round(x);
        x /= 100;
        return x;
    }
}
