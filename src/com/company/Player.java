package com.company;

import java.util.LinkedList;
import java.util.List;

public class Player extends Players{
    private Card card;

    public Player(String name, Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return card;
    }

    @Override
    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public List<Card> havingList() {
        List<Card> blackPlayer = new LinkedList<>();
        return blackPlayer;
    }
}
