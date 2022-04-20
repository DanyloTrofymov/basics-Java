package com.kpi;

public class ConsolePrinter {
    private final String INPUT_PLEASE_MSG = "<<< Input 0, 1 or 2: choose the function:\n " +
            "1 - Get information about subscribers whose time of intracity calls exceeds the set one.\n" +
            "2 - Get information about subscribers who used intercity communication.\n" +
            "0 - Exit.\n";
    private final String COUNT_OF_MINUTES = "Please enter the number of minutes\n";
    private final String TRY_AGAIN = "Please try again.\n";

    public void print(String value) {
        System.out.print( value );
    }

    public void printInputPleaseMsg(){
        print(INPUT_PLEASE_MSG);
    }

    public void printCountOfMinutes(){
        print(COUNT_OF_MINUTES);
    }
    
    public void printTryAgain() {
        System.out.print( TRY_AGAIN );
    }
}
