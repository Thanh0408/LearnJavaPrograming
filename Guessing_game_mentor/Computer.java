package com.company;

import java.util.Random;

public class Computer extends Gamer {
    public Computer() {
        name = "Computer";
        money = Integer.MAX_VALUE;
    }
    @Override
    public int guessNumber() {
        return generateNumber();
    }

    @Override
    public int generateNumber() {
        Random rd = new Random();
        number = rd.nextInt(100) + 1;
        return number;
    }
}