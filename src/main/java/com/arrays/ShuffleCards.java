package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Harshit on 9/21/2017.
 */
public class ShuffleCards {

    public enum Rank {DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};

    private final Rank rank;
    private final Suit suit;

    private ShuffleCards(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() { return rank; }
    public Suit suit() { return suit; }
    public static void main (String args []) {

        List<ShuffleCards> protoDeck = new ArrayList<ShuffleCards>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values())
                protoDeck.add(new ShuffleCards(rank, suit));
        }
        Collections.shuffle(protoDeck);

        for (ShuffleCards shuffleCards : protoDeck) {

            System.out.println(shuffleCards.rank + " " + shuffleCards.suit);

        }
    }
}
