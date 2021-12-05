package com.company;

import java.util.Random;
import java.util.Scanner;

public class Player extends Gamer {
    public Player() {
        name = "No name";
        money = 0;
    }
    public Player(String name) {
        this.name = name;
        money = 0;
    }
    @Override
    public int guessNumber() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }
    @Override
    public int generateNumber() {
        return guessNumber();
    }
}
