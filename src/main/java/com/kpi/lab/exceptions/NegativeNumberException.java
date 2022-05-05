package com.kpi.lab.exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(){
        super("Negative number.");
    }
}