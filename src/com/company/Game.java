package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean gameStatus;
    Croupier croupier;
    Player player;
    Koloda deck;
    Koloda cardInPlayer;
    Koloda cardInCroupier;
    List<Card> blackPlayer;
    List<Card> blackCroupier;
    List<Card> blackJack;
    public Game(Croupier croupier,  Player player, Koloda deck, Koloda cardInPlayer,
                Koloda cardInCroupier, List<Card> blackPlayer,  List<Card> blackCroupier, List<Card> blackJack) {
        this.croupier = croupier;
        this.player = player;
        this.deck = deck;
        this.cardInPlayer = cardInPlayer;
        this.cardInCroupier = cardInCroupier;
        this.blackPlayer = blackPlayer;
        this.blackCroupier = blackCroupier;
        this.blackJack = blackJack;
        gameStatus = true;
    }

    public void start() {
        System.out.println("__________________Start_______________\n");
        int num = 0;
        while (gameStatus) {
            printStatus();
            playerGetCard(randomCard(croupier.random()));
            num++;
            sumCard(num);
        }
    }
    private void printStatus() {

       for(Card a : blackCroupier){
            System.out.println(cardInCroupier.getName() + " CardName: "+ a.name + " CardValue: " + a.value);
        }
        System.out.println();
       for(Card i : blackPlayer){
            System.out.println(cardInPlayer.getName() + " CardName: "+ i.name + " CardValue: " + i.value);
        }


        System.out.println();

    }


    private  int randomCard(int index) {

        System.out.println("Раздача карты");


            croupier.setCard(deck.getCardInDeck(index));
            System.out.println("Выпало " + deck.getCardInDeck(index).getValue() + " " + deck.getCardInDeck(index).getName() );

       return index;
    }
    private void playerGetCard(int index) {
        Scanner player1 = new Scanner(System.in);
        System.out.println("Кто берет карту p/c");


        if (player1.nextLine().equals("p")){
            blackPlayer.add(blackJack.get(index));
            blackJack.remove(index);
        }
        else{
            blackCroupier.add(blackJack.get(index));
            blackJack.remove(index);
        }

    }
    private void sumCard(int num ) {
        int sumOfPlayer = 0;
        int sumOfCroupier = 0;
        for (Card i : blackPlayer) {
            sumOfPlayer += i.getValue();
        }
        for (Card i : blackCroupier) {
            sumOfCroupier += i.getValue();
        }
        if(num > 3){
            Scanner choice = new Scanner(System.in);
            System.out.println("Доберем карту? y/n");
            if(choice.nextLine().equals("y")){
                gameStatus = true;
            }else {
                if(sumOfPlayer == sumOfCroupier){
                    result(1);
                }else if((sumOfPlayer > sumOfCroupier) && sumOfCroupier<22){
                    result(-1);
                }else {
                    result(0);
                }
                gameStatus = false;
            }
        }
        if(num <=3 ){
            gameStatus = true;
        }

    }
    private void result(int index) {
        if (index == 0) {
            System.out.println("Croupier won \n" );
            System.exit(0);
        } else if (index == -1) {
            System.out.println("You won \n" );
            System.exit(-1);
        }
        else {
            System.out.println("Draw \n");
            System.exit(1);
        }
    }



}
