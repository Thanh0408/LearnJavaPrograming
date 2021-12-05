package com.company;

public class Fraction {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) throws DenominatorIsZeroException {
        if (denominator == 0) throw new DenominatorIsZeroException();
        this.denominator = denominator;
    }

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) throws DenominatorIsZeroException {
        setNumerator(numerator);
        setDenominator(denominator);
    }
    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

    public Fraction add(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.numerator;
        int d = f.denominator;
        Fraction res = new Fraction();
        res.numerator = a*d + b*c;
        res.denominator = b*d;
        return res;
    }

    public Fraction sub(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.numerator;
        int d = f.denominator;
        Fraction res = new Fraction();
        res.numerator = a*d - b*c;
        res.denominator = b*d;
        return res;
    }

    public Fraction div(Fraction f) throws DenominatorIsZeroException {
        int a = numerator;
        int b = denominator;
        int c = f.numerator;
        int d = f.denominator;
        Fraction res = new Fraction(a * d,b * c);
//        res.numerator = a * d;
//        res.setDenominator(b * c);
        return res;
    }

    public Fraction mul(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.numerator;
        int d = f.denominator;
        Fraction res = new Fraction();
        res.numerator = a * c;
        res.denominator = b * d;
        return res;
    }
}
