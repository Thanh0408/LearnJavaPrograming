package com.company;

import java.util.Scanner;

public abstract class MenuProgram {
    public void run(){
        FractionProgram fractionProg = new FractionProgram();
        boolean fractionRunning = true;
        int yourChoice;
        while (fractionRunning) {
            fractionProg.printMenu();
            yourChoice = nextInt("Your choice:");
            fractionProg.doTask(yourChoice);
            if(yourChoice == 5) fractionRunning = false;
        }
    }
    protected int nextInt(String message) {
        System.out.print(message);
        int int_number = 0;
        boolean invalidInput = true;
        while(invalidInput){
            try{
                Scanner scan = new Scanner(System.in);
                int_number = scan.nextInt();
                invalidInput = false;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again!");
                System.out.println(message);
            }
        }
        return int_number;
    }
    protected abstract void doTask(int choice) throws DenominatorIsZeroException;
    protected abstract void printMenu();

}
