package com.kpi.exceptions;

public class WrongFunctionException extends Exception{
    public WrongFunctionException(){
        super("It is impossible function type!");
    }
}
