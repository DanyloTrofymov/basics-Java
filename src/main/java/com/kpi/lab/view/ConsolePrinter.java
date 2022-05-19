package com.kpi.lab.view;

import com.kpi.lab.model.entity.Subscriber;

import java.util.List;

public class ConsolePrinter {
    public static final String MENU = """
            Сhoose the function:
            1 - Get information about subscribers whose time of intracity calls exceeds the set one.
            2 - Get information about subscribers who used intercity communication.
            3 - Save your changes.
            4 - Load last saved version(progress will be lost).
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
    public static final String EMPTY_DATA = "Data is empty! Load before start!\n";
    public static final String EMPTY_RESULT = "Result is empty:\n";
    public static final String NEGATIVE_NUMBER = "Wrong number format. Need to be only positive number.\n";
    public static final String WRONG_FUNCTION = "Function with this number does not exists. Choose function from list.\n";
    public static final String WRONG_FILE_FORMAT = "Wrong file format. Need to be \".json\" \n";
    public static final String WANT_TO_SAVE = "If you want to save result to the file type \"Y\" \n";
    public static final String ENTER_PATH = "Please enter path where you want to save your data or enter \"default\" for default path \"...\\client storage\\result.json\" \n";
    public static final String NOT_SAVED = "File was not saved.\n";
    public static final String CHECK_PATH = "Check if path is correct.\n";
    public static final String NOT_LOADED = "File was not loaded.\n";
    public static final String SAVE_CHANGES = "Do you want to save changes? Enter \"Y\" if yes.\n";
    public void print(String value) {
        System.out.print(value);
    }

    public void printResult(List<Subscriber> subs) {
        if (subs.isEmpty()) {
            print(EMPTY_RESULT);
        } else {
            subs.forEach(System.out::println);
        }
    }
}