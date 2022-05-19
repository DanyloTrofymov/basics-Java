package com.kpi.lab.model.exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(){
        super("Negative number.");
    }
}