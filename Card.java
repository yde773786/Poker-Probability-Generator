package com.example.pokerprobablitygenerator;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;

class Card implements Parcelable {

    int number;
    String suit;

    public Card(int number,String suit) {
        this.number = number;
        this.suit = suit;
    }


    public static boolean pair (Card A[]){
        for(int i = 0; i <=5 ; i++){
            int cnt = 1;
            for(int j = i+1 ; j < A.length ; j++)
                if(A[i].number==A[j].number){
                    cnt++;
                    if(cnt==2)
                        return true;
                }
        }
        return false;
    }

    public static boolean two_pair (Card A[]){
        int cnt_counter = 0;
        for(int i = 0; i <=5 ; i++) {
            int cnt = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i].number == A[j].number) {
                    cnt++;
                }
            }
            if (cnt == 2)
                cnt_counter++;
            if (cnt_counter == 2)
                return true;
        }
            return false;
    }

    public static boolean three_of_a_kind (Card A[]){
        for(int i = 0; i <=4 ; i++){
            int cnt = 1;
            for(int j = i+1 ; j < A.length ; j++)
                if(A[i].number==A[j].number){
                    cnt++;
                    if(cnt==3)
                        return true;
                }
        }
        return false;
    }

    public static boolean straight(Card A[]) {
        Card B[] = new Card[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = new Card(A[i].number, A[i].suit);
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length - 1 - i; j++) {
                if (B[j].number > B[j + 1].number) {
                    Card tmp = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i <= 2; i++) {
            int cnt = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (B[j - 1].number == B[j].number)
                    continue;
                if (B[i].number + cnt == B[j].number) {
                    cnt++;
                    if (cnt == 5)
                        return true;
                }
                else
                    break;
            }
        }
        return false;
    }

    public static boolean flush (Card A[]) {

        for(int i = 0; i <=2 ; i++){
            int cnt = 1;
            for(int j = i+1 ; j < A.length ; j++)
                if(A[i].suit.equals(A[j].suit)){
                    cnt++;
                    if(cnt==5)
                        return true;
                }
        }
        return false;
    }

    public static boolean full_house(Card A[]){
        int three_counter = 0, two_counter = 0;
        int cnt_2 = 0;
        for(int i = 0; i <=5 ; i++){
            int cnt = 1;
            for(int j = i+1 ; j < A.length ; j++) {
                if (A[i].number == A[j].number) {
                    cnt++;

                }
            }

            if (cnt == 3){
                three_counter++;
            }
            else if (cnt == 2)
                two_counter++;
            if(three_counter>=1&&cnt_2==0){
                cnt_2++;
                two_counter--;

            }
            if (three_counter>=1 && two_counter>=1)
                return true;
        }
        return false;
    }


    public static boolean four_of_a_kind (Card A[]){
        for(int i = 0; i <=3 ; i++){
            int cnt = 1;
            for(int j = i+1 ; j < A.length ; j++)
                if(A[i].number==A[j].number){
                    cnt++;
                    if(cnt==4)
                        return true;
                }
        }
        return false;
    }

    public static boolean straight_flush (Card A[]){
        Card B[] = new Card[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = new Card(A[i].number, A[i].suit);
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length - 1 - i; j++) {
                if (B[j].number > B[j + 1].number) {
                    Card tmp = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i <= 2; i++) {
            int cnt = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (B[j - 1].number == B[j].number)
                    continue;
                if (B[i].number + cnt == B[j].number && B[i].suit.equals(B[j].suit)) {
                    cnt++;
                    if (cnt == 5)
                        return true;
                }
                else
                    break;
            }
        }
        return false;
    }
    public static boolean verify_hand(Card player_hand[]) {

        for(int i = 0; i<player_hand.length;i++) {
            for(int j = i+1; j<player_hand.length;j++ )
                if(player_hand[i].number == player_hand[j].number && player_hand[i].suit.equals(player_hand[j].suit) )
                    return true;
        }

            return false;
    }


    public static String check_hand(Card player_hand[] ) {
        if(Card.verify_hand(player_hand))
            return "WRONG INPUT";
        if (Card.straight_flush(player_hand))
            return "STRAIGHT FLUSH" ;
        if (Card.four_of_a_kind(player_hand))
            return "FOUR OF A KIND" ;
        if (Card.full_house(player_hand))
            return "FULL HOUSE" ;
        if (Card.flush(player_hand))
            return "FLUSH" ;
        if (Card.straight(player_hand))
            return "STRAIGHT";
        if (Card.three_of_a_kind(player_hand))
            return "THREE OF A KIND";
        if (Card.two_pair(player_hand))
            return "TWO PAIR" ;
        if (Card.pair(player_hand))
            return "PAIR";
        else
            return "HIGH CARD";
    }



    protected Card(Parcel in) {
        number = in.readInt();
        suit = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(suit);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
    public String toString(){
        return "Card :: " + suit + " && " + number;

    }
}