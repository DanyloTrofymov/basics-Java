package com.kpi.lab;

import com.kpi.lab.exceptions.EmptyResultException;
import com.kpi.lab.exceptions.WrongFunctionException;
import com.kpi.lab.exceptions.WrongInputNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class SubscriberView {
    private final ConsolePrinter printer;
    private static final Logger logger = LoggerFactory.getLogger(SubscriberView.class);
    public SubscriberView(ConsolePrinter printer) {
        this.printer = printer;
    }

    public ConsolePrinter getPrinter() {
        return printer;
    }

    public int chooseFunction() {
        Scanner scanner = new Scanner(System.in);
        printer.printInputPleaseMsg();
        String functionTypeString = scanner.next();
        try {
            Validator.validatePositiveNumbersInput(functionTypeString);
            int functionType = Integer.parseInt(functionTypeString);
            Validator.checkFunctionType(functionType);
            return functionType;
        } catch (WrongInputNumberException | WrongFunctionException e) {
            logger.error(e.getMessage(), e);
            printer.print(e.getMessage());
            printer.printTryAgain();
        }
        return -1;
    }

    public int countOfMinutes() {
        Scanner scanner = new Scanner(System.in);
        printer.printCountOfMinutes();
        String minutesString = scanner.next();
        int minutes = -1;
        try {
            Validator.validatePositiveNumbersInput(minutesString);
            minutes = Integer.parseInt(minutesString);

        } catch (WrongInputNumberException e) {
            logger.error(e.getMessage(), e);
            printer.print(e.getMessage());
        }
        return minutes;
}

    public void printArray(ArrayList<Subscriber> subs) {
        try {
        Validator.checkResult(subs);
            for (Subscriber sub : subs) {
                printer.print(sub.toString());
            }
        } catch (EmptyResultException e) {
            logger.error(e.getMessage(), e);
            printer.print(e.getMessage());
        }
    }
}
