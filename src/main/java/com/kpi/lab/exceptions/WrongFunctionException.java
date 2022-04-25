package com.kpi.lab.exceptions;

public class WrongFunctionException extends Exception{
    public WrongFunctionException(){
        super("It is impossible function type!");
    }
}
