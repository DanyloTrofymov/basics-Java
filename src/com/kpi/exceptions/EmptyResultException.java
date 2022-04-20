package com.kpi.exceptions;

public class EmptyResultException extends Exception{
    public EmptyResultException(){
        super("Result is empty!");
    }
}
