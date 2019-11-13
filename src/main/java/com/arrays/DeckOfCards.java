package com.arrays;

public class DeckOfCards {

    public static void main (String args[]){

        int[] deck = new int[52];

        String [] suit = {"Spades","Heart","Diamond","Club"};

        for (int i = 0; i <deck.length ; i++) {
            deck[i] = i;

        }

        for (int i = 0; i < deck.length ; i++) {
            int j = (int)(Math.random()*deck.length);
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        for(int i=0; i<4;i++){

         int card = deck[i] %13;

         if(card == 0){

             System.out.println("Card Number " + deck[i] + " is King of "+ suit[deck[i]/13]);

         }
          else if(card == 11){
             System.out.println("Card Number " + deck[i] + " is Jack of "+ suit[deck[i]/13]);
         }
         else if (card == 12){
             System.out.println("Card Number " + deck[i] + " is Queen of "+ suit[deck[i]/13]);
         }

         else if (card == 1){
             System.out.println("Card Number " + deck[i] + " is Ace of "+ suit[deck[i]/13]);
         }
         else System.out.println("Card Number " + deck[i] + " is "+ card + " of "+ suit[deck[i]/13]);

        }


    }
}
