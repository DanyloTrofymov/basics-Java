package com.kpi.lab;

import com.kpi.lab.exceptions.EmptyResultException;
import com.kpi.lab.exceptions.WrongFunctionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class SubscriberView {
    private final ConsolePrinter printer;
    private static final Logger logger = LoggerFactory.getLogger(SubscriberView.class);
    public SubscriberView(ConsolePrinter printer) {
        this.printer = printer;
    }

    public int chooseFunction() {
        Scanner scanner = new Scanner(System.in);
        String functionTypeString = scanner.next();
        try {
            int functionType = Integer.parseInt(functionTypeString);
            Validator.checkFunctionType(functionType);
            return functionType;
        } catch ( WrongFunctionException e) {
            logger.error(e.getMessage(), e);
            printer.print(e.getMessage());
            printer.print(printer.TRY_AGAIN);
        }
        return -1;
    }

    public int countOfMinutes() {
        Scanner scanner = new Scanner(System.in);
        printer.print(printer.COUNT_OF_MINUTES);
        String minutesString = scanner.next();
        int minutes = -1;
        try {
            minutes = Integer.parseInt(minutesString);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            printer.print(e.getMessage());
        }
        return minutes;
}

    public void outputArray(List<Subscriber> subs) {
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

    public void outputMessage(String msg){
        printer.print(msg);
    }
}
