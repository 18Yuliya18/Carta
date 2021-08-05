package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> blackJack = new ArrayList<>();

        List<String> mast = new ArrayList<>();
        mast.add("Пика");
        mast.add("Хреста");
        mast.add("Буба");
        mast.add("Черва");

        List<Integer> meaning = new ArrayList<>();
        meaning.add(6);
        meaning.add(7);
        meaning.add(8);
        meaning.add(9);
        meaning.add(10);
        meaning.add(3);
        meaning.add(4);
        meaning.add(5);
        meaning.add(11);

        for (int i = 0; i < mast.size(); i++) {
            for (int j = 0; j < meaning.size(); j++) {
                blackJack.add(new Card(mast.get(i), meaning.get(j)));
            }
        }
        for (Card a : blackJack){
            System.out.println("CardName: " + a.name + " CardValue: " + a.value);
        }

            // git,
        Player player = new Player("Player1", null);
        Croupier croupier = new Croupier("Croupier1", null, blackJack);

        Koloda deck = new Koloda("Koloda", blackJack);
        Koloda cardInPlayer = new Koloda("cardInPlayer", player.havingList());
        Koloda cardInCroupier = new Koloda("cardInCroupier", croupier.havingList());



        Game game = new Game(croupier, player, deck, cardInPlayer, cardInCroupier, player.havingList(),
                    croupier.havingList(), blackJack);
            game.start();
        }
    }

