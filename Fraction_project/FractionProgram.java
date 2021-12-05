package com.company;

public class FractionProgram extends MenuProgram {

    @Override
    protected void printMenu(){
        System.out.println("====================Menu=====================");
        System.out.println("1. Adding fractions");
        System.out.println("2. Subtracting fractions");
        System.out.println("3. Dividing fractions");
        System.out.println("4. Multiplying fractions");
        System.out.println("5. Exit.");
        System.out.println("---------------------------------------------");
    }

    @Override
    protected void doTask(int choice){
        switch (choice) {
            case 1: demoAddition(); break;
            case 2: demoSubtraction(); break;
            case 3: demoDivision(); break;
            case 4: demoMultiplication(); break;
            case 5: break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void demoAddition(){
        Fraction f1 = nextFraction();
        Fraction f2 = nextFraction();
        Fraction f3 = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + f3);
    }

    private void demoSubtraction(){
        Fraction f1 = nextFraction();
        Fraction f2 = nextFraction();
        Fraction f3 = f1.sub(f2);
        System.out.println(f1 + " + " + f2 + " = " + f3);
    }

    private void demoDivision() {
        try {
            Fraction f1 = nextFraction();
            Fraction f2 = nextFraction();
            Fraction f3 = f1.div(f2);
            System.out.println(f1 + " / " + f2 + " = " + f3);
        } catch (DenominatorIsZeroException d) {
            d = new DenominatorIsZeroException("result have zero denominator!");
            System.out.println(d);
        }
    }

    private void demoMultiplication(){
        Fraction f1 = nextFraction();
        Fraction f2 = nextFraction();
        Fraction f3 = f1.mul(f2);
        System.out.println(f1 + " . " + f2 + " = " + f3);
    }

    private Fraction nextFraction(){
        System.out.println("Input fraction: ");
        Fraction nextFra = new Fraction();
        int tempNumber;
        boolean check_Denominator_Zero = true;
        while (check_Denominator_Zero) {
            try {
                tempNumber = nextInt("Numerator: ");
                nextFra.setNumerator(tempNumber);
                tempNumber = nextInt("Denominator: ");
                nextFra.setDenominator(tempNumber);
                check_Denominator_Zero = false;
            } catch (DenominatorIsZeroException d_next) {
                System.out.println(d_next);
                System.out.println("Try input gain your number!");
            }
        }
        return nextFra;
    }

}