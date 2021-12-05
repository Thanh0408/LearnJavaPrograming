package com.company;

public class DenominatorIsZeroException extends Exception {
    public DenominatorIsZeroException() {
        super("Error: Denominator is zero!");
    }
    public DenominatorIsZeroException(String message) {
        super(message);
    }
}
