package com.company;

public class FullTime extends Employee{
    public FullTime(String name, double rate) {
        super(name, rate);
    }
    @Override
    public double salary(){
        return BASIC_SALARY * rate;
    }

}
