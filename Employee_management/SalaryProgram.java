package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class SalaryProgram {
//    private ArrayList<Employee> employ = new ArrayList<Employee>();
    private Employee employee[] = new Employee[10];
    /* numb is numbers of employee exists */
    private int numb = Employee.count;
    Scanner console = new Scanner(System.in);

    /* menu function */
    protected void printMenu(){
        System.out.println("===============================MENU============================");
        System.out.println("Option 1: Add a new full time staff.(Staff ID, Name, Rate)");
        System.out.println("Option 2: Add a new part time staff.(Staff ID, Name, Rate, Work days per month");
        System.out.println("Option 3: Add a new hourly staff.(Staff ID, Name, Rate, Hours per month");
        System.out.println("Option 4: Calculate salary of staff on a month.(searching for by Name)");
        System.out.println("Option 5: Calculate salary of staff on a month.(searching for by Staff ID)");
        System.out.println("Option 6: Exit.");
        System.out.print(" ==== Your choice: ");
    }

    protected void doTask (int option) {
        String name_staff;
        double rate_staff;
        /* time_staff_days is working time of part-time employee*/
        int time_staff_days;
        int search_ID;
        /* time_staff_hours is working time of hourly-employee*/
        double time_staff_hours;

        switch (option) {
            case 1:
                System.out.print("Name: ");
                name_staff = console.nextLine();
                System.out.print("Rate: ");
                rate_staff = Double.parseDouble(console.nextLine());

                addFullTime(name_staff, rate_staff);
                break;
            case 2:
                System.out.print("Name: ");
                name_staff = console.nextLine();
                System.out.print("Rate: ");
                rate_staff = Double.parseDouble(console.nextLine());
                System.out.print("Days: ");
                time_staff_days = Integer.parseInt(console.nextLine());

                addPartTime(name_staff, rate_staff, time_staff_days);
                break;
            case 3:
                System.out.print("Name: ");
                name_staff = console.nextLine();
                System.out.print("Rate: ");
                rate_staff = Double.parseDouble(console.nextLine());
                System.out.print("Hours: ");
                time_staff_hours = Double.parseDouble(console.nextLine());

                addHourly(name_staff, rate_staff, time_staff_hours);
                break;
            case 4:
                System.out.print("Searching name: ");
                name_staff = console.nextLine();

                calculateSalaries(name_staff);
                break;
            case 5:
                System.out.print("Searching ID: ");
                search_ID = Integer.parseInt(console.nextLine());

                calculateSalaries(search_ID);
                break;
            default:
                System.out.println("Good bye");
                break;
        }
    }

    private void addFullTime(String name, double rate) {
        /* create a object of Full-time employee */
        FullTime full = new FullTime(name, rate);
        /* save info object into control list */
        employee[numb] = full;
        numb++;
    }

    private void addPartTime(String name, double rate,int days) {
        /* create a object of Part-time employee */
        PartTime part = new PartTime(name, rate, days);
        /* save info object into control list */
        employee[numb] = part;
        numb++;
    }

    private void addHourly(String name, double rate, double hours) {
        /* create a object of Hour-time employee */
        HourlyEmployee hourlyEmployee = new HourlyEmployee(name, rate, hours);
        /* save info object into control list */
        employee[numb] = hourlyEmployee;
        numb++;
    }

    private void calculateSalaries(String name_staff) {
        for(int i = 0; i < numb; i++){
            if (name_staff.equals(employee[i].name)){
                employee[i].info();
                System.out.println("salary: " + employee[i].salary());
                System.out.println();
            }
        }
    }

    private void calculateSalaries(int search_ID) {
        if (search_ID - 1 < numb) {
            employee[search_ID - 1].info();
            System.out.println("salary: " + employee[search_ID - 1].salary());
            System.out.println();
        }else{
            System.out.println("No result matched.");
            System.out.println();
        }
    }
}
