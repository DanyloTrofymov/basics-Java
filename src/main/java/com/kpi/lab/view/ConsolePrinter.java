package com.kpi.lab;

public class ConsolePrinter {
    public static final String MENU = """
            Сhoose the function:
            1 - Get information about subscribers whose time of intracity calls exceeds the set one.
            2 - Get information about subscribers who used intercity communication.
            3 - Save the data to JSON file.
            4 - Load the data from JSON file.
            5 - Generate random data.
            6 - Print all subscribers.
            0 - Exit.
            """;
    public static final String COUNT_OF_MINUTES = "Please enter the number of minutes.\n";
    public static final String LOADED = "Data was loaded successfully.\n";
    public static final String SAVED = "Data was saved successfully.\n";
    public static final String TRY_AGAIN = "Please try again.\n";
    public static final String GENERATED = "Data was generated successfully.\n";
    public static final String ALL_DATA = "All information:\n";
    public static final String EMPTY_DATA = "Data is empty:\n";
    public void print(String value) {
        System.out.print( value );
    }
}
