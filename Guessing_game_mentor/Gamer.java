package com.company;

public abstract class Gamer {
    protected int number;
    protected String name;
    protected int money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public int getNumber() {
        return number;
    }
    public Gamer() {
        number = 0;
    }
    public abstract int guessNumber();
    public abstract int generateNumber();
}