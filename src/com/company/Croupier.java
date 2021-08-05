package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Croupier extends Players{
    private Card card;
    String name;
    List<Card> blackJack;
    public Croupier(String name, Card card,List<Card> blackJack ) {
        this.name = name;
        this.card = card;
        this.blackJack = blackJack;
    }
    public  int random (){
        int index = new Random().nextInt(blackJack.size());
        return index;
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
    public List<Card> havingList(){
        List<Card> blackCroupier = new LinkedList<>();
        return blackCroupier;
    }
}

