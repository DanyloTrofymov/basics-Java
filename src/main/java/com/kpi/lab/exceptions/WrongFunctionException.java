package com.kpi.lab.exceptions;

public class WrongFunctionException extends RuntimeException{
    public WrongFunctionException(){
        super("It is impossible function type!");
    }
}
