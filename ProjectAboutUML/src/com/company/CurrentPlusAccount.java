package com.company;

public class CurrentPlusAccount {
    private double minBalance; 
    private double intRate;
    public CurrentPlusAccount(int idNumber, double startBal,  double chkCharge,double minBal, double rate) {
        super(idNumber, startBal, chkCharge);
        minBalance= minBal;
        intRate = rate;
    } 
    public void clearCheck(double amount) {
        if (currentBalance() >= minBalance)
            decreaseBalance(amount);
        else
            super.clearCheck(amount);
    } 
    public double monthlyInterest() {
    if (/* write code here */) 
        return (currentBalance() * (intRate / 12.0));
    else
        return super.monthlyInterest();
    }
}
