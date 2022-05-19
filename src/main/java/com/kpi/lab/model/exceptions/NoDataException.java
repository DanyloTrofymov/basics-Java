package com.kpi.lab.model.exceptions;

public class NoDataException extends RuntimeException{
    public NoDataException(){
        super("No data defined");
    }
}
