package com.kpi.lab.view;

import com.kpi.lab.service.Validator;
import com.kpi.lab.model.exceptions.WrongFunctionException;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SubscriberView {
    private final ConsolePrinter printer;
    private static final Logger logger = Logger.getLogger(SubscriberView.class);
    private final Scanner scanner = new Scanner(System.in);
    public SubscriberView(ConsolePrinter printer) {
        this.printer = printer;
    }

    public int chooseFunction() {
        printer.print(ConsolePrinter.MENU);
        do {
        Scanner scanner = new Scanner(System.in);
        String functionTypeString = scanner.next();
        try {
            int functionType = Integer.parseInt(functionTypeString);
            Validator.validateFunctionType(functionType);
            return functionType;
        } catch (WrongFunctionException e) {
            logger.error(e.getMessage(), e);
            printer.print(ConsolePrinter.WRONG_FUNCTION);
            printer.print(ConsolePrinter.TRY_AGAIN);
        }
        }while(true);
    }

    public int countOfMinutes() {
        printer.print(ConsolePrinter.COUNT_OF_MINUTES);
        do {
            String minutesString = scanner.next();
            try {
                int minutes = Integer.parseInt(minutesString);
                Validator.validatePositiveNumbersInput(minutes);
                return minutes;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                printer.print(ConsolePrinter.NEGATIVE_NUMBER);
                printer.print(ConsolePrinter.TRY_AGAIN);
            }
        }while(true);
    }
    public boolean wantToSave(){
        printer.print(ConsolePrinter.WANT_TO_SAVE);
        String answ = scanner.next();
        return answ.equalsIgnoreCase("y");
    }
    public Path getPath() {
        printer.print(ConsolePrinter.ENTER_PATH);
        do {
            try {
                String dir = scanner.next();
                if (dir.equalsIgnoreCase("default")) {
                    dir = System.getProperty("user.dir") + System.getProperty("file.separator") + "client storage";
                    return Paths.get(dir).resolve("result.json");
                } else {
                    Validator.validateFileFormat(dir);
                    return Paths.get(dir);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                printer.print(ConsolePrinter.WRONG_FILE_FORMAT);
                printer.print(ConsolePrinter.TRY_AGAIN);
            }
        } while (true);
    }
}