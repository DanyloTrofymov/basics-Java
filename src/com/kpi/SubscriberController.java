package com.kpi;

import com.kpi.exceptions.WrongFunctionException;
import com.kpi.exceptions.WrongInputNumberException;

public class SubscriberController {
    private SubscriberModel model;
    private SubscriberView view;

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
                    case 0: {
                        work = false;
                        break;
                    }
                    case 1: {
                        int minutes = view.countOfMinutes();
                        Validator.validatePositiveNumbersInput(Integer.toString(func));
                        view.printArray(model.intracityMoreThen(minutes));
                        break;
                    }
                    case 2: {
                        view.printArray(model.usedIntercityCommunication());
                        break;
                    }
                }
            } while (work);
        } catch (WrongInputNumberException | WrongFunctionException e) {
            view.getPrinter().print(e.getMessage());
        }
    }
}
