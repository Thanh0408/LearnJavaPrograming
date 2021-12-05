package com.company;

abstract class Employee {
    protected int id;
    protected String name;
    protected double rate;

    protected static int count = 0;
    protected static double BASIC_SALARY;

    public Employee(String name, double rate) {
        this.name = name;
        this.rate = rate;
        this.BASIC_SALARY = 5000000;
        count++;
        this.id = count;
    }

    public void info () {
        System.out.print("Name: " + name + ", ID: " + id + ", ");
    }

    public abstract double salary();
}

