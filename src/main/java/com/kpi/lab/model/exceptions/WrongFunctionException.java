package com.kpi.lab.model.exceptions;

public class WrongFunctionException extends RuntimeException{
    public WrongFunctionException(){
        super("It is impossible function type!");
    }
}
