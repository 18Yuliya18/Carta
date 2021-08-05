package com.company;

import java.util.List;

public class Koloda {
    private String name;

    private List<Card> cardInDeck;
    public Koloda(String name, List<Card> cardInDeck) {
        this.name = name;
        this.cardInDeck = cardInDeck;
    }

    public Card getCardInDeck(int ind) {
        return cardInDeck.get(ind);
    }

    public String getName() {
        return name;
    }
}
