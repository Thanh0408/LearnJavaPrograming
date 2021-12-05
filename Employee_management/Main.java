package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int your_choice;
        boolean check = true;
        SalaryProgram salary = new SalaryProgram();

        while(check){
            /* show menu on the screen */
            salary.printMenu();
            /* input choice option */
            your_choice = Integer.parseInt(console.nextLine());
            if (your_choice >=1 && your_choice <= 6){
                salary.doTask(your_choice);
            }else{
                System.out.println("Do not have your option. Try again!");
            }

            if (your_choice == 6) check = false;
        }
    }
}
