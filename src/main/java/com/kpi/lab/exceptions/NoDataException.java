package com.kpi.lab.exceptions;

public class NoDataException extends RuntimeException{
    public NoDataException(){
        super("No data defined");
    }
}
