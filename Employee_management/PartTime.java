package com.company;

public class PartTime extends Employee {
    /* numbers of working day fer month */
    private int days;

    public PartTime(String name, double rate, int days) {
        super(name, rate);
        this.days = days;
    }

    @Override
    public double salary(){
        return BASIC_SALARY * rate * days * 8 / 160;
    }
}
