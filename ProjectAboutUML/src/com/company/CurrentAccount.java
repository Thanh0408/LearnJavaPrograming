package com.company;

public class CurrentAccount extends Account {
    private double checkCharge;
    public CurrentAccount(int idNumber, double startBal, double chkCharge){
        super(idNumber, startBal);
        checkCharge = chkCharge;
    }
    public void clearCheck(double amount) {
        C;// u write code here
    }
    public double monthlyInterest() {
        return 0.0;
    }
}
