package com.kpi.lab;

import com.kpi.lab.exceptions.WrongFunctionException;
import com.kpi.lab.exceptions.WrongInputNumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberView.class);
    private final SubscriberModel model;
    private final SubscriberView view;

    public SubscriberController(SubscriberModel model, SubscriberView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean work = true;
        try {
            do {
                int func = view.chooseFunction();
                Validator.checkFunctionType(func);
                switch (func) {
                    case 0 -> {
                        work = false;
                    }
                    case 1 -> {
                        int minutes = view.countOfMinutes();
                        Validator.validatePositiveNumbersInput(minutes);
                        view.printArray(model.intracityMoreThen(minutes));
                    }
                    case 2 -> {
                        view.printArray(model.usedIntercityCommunication());
                    }
                    case 3 -> {
                        model.save();
                        view.getPrinter().printSavedMsg();
                    }
                    case 4 -> {
                        model.load();
                        view.getPrinter().printLoadedMsg();
                    }
                    case 5 -> {
                        model.generateData();
                        view.getPrinter().printGeneratedMsg();
                    }
                    case 6 -> {
                        view.getPrinter().printAllDAtaMsg();
                        view.printArray(model.getAllCustomersInSystem());
                    }
                }
            } while (work);
        } catch (WrongInputNumberException | WrongFunctionException e) {
            logger.error(e.getMessage(), e);
            view.getPrinter().print(e.getMessage());
        }
    }
}
