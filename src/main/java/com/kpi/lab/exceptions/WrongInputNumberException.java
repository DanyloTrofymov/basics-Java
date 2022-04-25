package com.kpi.lab.exceptions;

public class WrongInputNumberException extends Exception {
    public WrongInputNumberException(){
        super("Wrong number format. Need to be only positive number.");
    }
}