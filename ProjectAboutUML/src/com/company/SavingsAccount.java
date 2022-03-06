package com.company;

public class SavingsAccount extends Account {
    private double intRate; // annual interest rate for
    public SavingsAccount(int idNumber, double balance, double rate) {
        super(idNumber, balance);// write code here
        intRate=rate;
    } 
    public double monthlyInterest() {
        return (currentBalance() * (intRate / 12.0));
    }
    public void withdraw(double amount) {
        decreaseBalance(amount);
    }
}
