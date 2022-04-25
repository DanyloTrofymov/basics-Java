package com.kpi.lab;

public class ConsolePrinter {
    private final String INPUT_PLEASE_MSG = """
            Input 0, 1 or 2: choose the function:
            1 - Get information about subscribers whose time of intracity calls exceeds the set one.
            2 - Get information about subscribers who used intercity communication.
            3 - Save the data to JSON file.
            4 - Load the data from JSON file.
            5 - Generate random data.
            6 - Print all subscribers.
            0 - Exit.
            """;
    private final String COUNT_OF_MINUTES = "Please enter the number of minutes.\n";

    private final String LOADED = "Data was loaded successfully.\n";

    private final String SAVED = "Data was saved successfully.\n";
    private final String TRY_AGAIN = "Please try again.\n";

    private final String GENERATED = "Data was generated successfully.\n";
    private final String ALL_DATA = "All information:\n";
    public void print(String value) {
        System.out.print( value );
    }
    public void printAllDAtaMsg(){
        print(ALL_DATA);
    }
    public void printGeneratedMsg(){
        print(GENERATED);
    }
    public void printLoadedMsg(){
        print(LOADED);
    }
    public void printSavedMsg(){
        print(SAVED);
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
