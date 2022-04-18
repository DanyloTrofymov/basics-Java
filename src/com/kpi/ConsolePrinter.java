package com.kpi;

public class ConsolePrinter {
    private final String INPUT_PLEASE_MSG = "<<< Input 1 or 2: choose the function:\n " +
            "1 - Get information about subscribers whose time of intracity calls exceeds the set one.\n" +
            "2 - Get information about subscribers who used intercity communication.\n";
    private final String IT_IS_IMPOSSIBLE_FUNCTION_MSG = "It is impossible function type!\n";
    private final String WANT_TO_CONTINUE_MSG = "If you want to stop press 0, else you will continue\n";
    private final String COUNT_OF_MINUTES = "Please enter the number of minutes\n";

    public void print(String value) {
        System.out.print( value );
    }

    public void printInputPleaseMsg(){
        print(INPUT_PLEASE_MSG);
    }

    public void printImpossibleFunction(){
        print(IT_IS_IMPOSSIBLE_FUNCTION_MSG);
    }

    public void printWantToContinueMsg(){
        print(WANT_TO_CONTINUE_MSG);
    }
    public void printCountOfMinutes(){
        print(COUNT_OF_MINUTES);
    }
}
