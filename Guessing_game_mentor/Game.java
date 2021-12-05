package com.company;

import java.util.Scanner;

public class Game {
    private Gamer answeringPlayer;
    private Gamer askingPlayer;
    private final int ASKING = 1;
    private final int ANSWERING = 2;
    public Game() {
        // player = new Player();
        // askingPlayer = new Computer();
    }
    public void start() {
        // ask user want to guess or not
        int choice = chooseOption();
        if (choice == ASKING) {
            askingPlayer = createNewPlayer();
            answeringPlayer = new Computer();
        } else {
            askingPlayer = new Computer();
            answeringPlayer = createNewPlayer();
        }
        welcomePlayer();
        System.out.println("Generate a number to guess");
        int compNumber = askingPlayer.generateNumber();
        System.out.println("Computer has generate a number. Can you guess?");
        boolean playing = true;
        while (playing) {
            System.out.println("Enter your guess: ");
            int playerNumber = answeringPlayer.guessNumber();
            if (compNumber == playerNumber) {
                congrats();
                playing = false;
            } else {
                boolean less = playerNumber < compNumber;
                handleIncorrect(less);
                playing = isContinue();
            }
        }
    }
    private Gamer createNewPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        answeringPlayer = new Player(scanner.nextLine());
        System.out.print("Enter amount of money: ");
        answeringPlayer.setMoney(scanner.nextInt());
        return answeringPlayer;
    }
    private void welcomePlayer() {
        System.out.println("Welcome player " + askingPlayer.getName());
    }
    private void congrats() {
        int newMoney = answeringPlayer.getMoney() + 5;
        answeringPlayer.setMoney(newMoney);
        System.out.println("Correct! You win!");
        System.out.println("Your money: " + answeringPlayer.getMoney());
    }
    private void handleIncorrect(boolean less) {
        int newMoney = answeringPlayer.getMoney() - 1;
        answeringPlayer.setMoney(newMoney);
        if (less) {
            System.out.println("Your number is less than computer's");
        } else {
            System.out.println("Your number is greater than computer's");
        }
        System.out.println("Your money: " + answeringPlayer.getMoney());
    }
    private  boolean isContinue() {
        return answeringPlayer.getMoney() > 0;
    }
    private int chooseOption() {
        System.out.println("1. Asking");
        System.out.println("2. Answering");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}