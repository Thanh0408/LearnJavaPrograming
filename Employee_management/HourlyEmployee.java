package com.company;

public class HourlyEmployee extends Employee {
    /* hours is working time per month of staff */
    private double hours;

    HourlyEmployee(String name, double rate, double hours) {
        super(name, rate);
        this.hours = hours;
    }

    @Override
    public double salary() {
        return rate * BASIC_SALARY * hours /160;
    }


}
