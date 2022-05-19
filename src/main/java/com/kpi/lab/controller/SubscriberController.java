package com.kpi.lab.controller;

import com.kpi.lab.service.DataManager;
import com.kpi.lab.model.entity.Subscriber;
import com.kpi.lab.model.SubscriberModel;
import com.kpi.lab.service.Validator;
import com.kpi.lab.view.ConsolePrinter;
import com.kpi.lab.view.SubscriberView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.util.List;

public class SubscriberController {
    private static final Logger logger = LogManager.getLogger(SubscriberController.class);
    private final SubscriberModel model;
    private final ConsolePrinter printer;
    private final SubscriberView view;

    public SubscriberController(SubscriberModel model, SubscriberView view, ConsolePrinter printer) {
        this.model = model;
        this.view = view;
        this.printer = printer;
    }

    public void start() {
        loadDataController();
        boolean work = true;
        do {
            int func = view.chooseFunction();
            Validator.validateFunctionType(func);
            switch (func) {
                case 0 -> {
                    printer.print(ConsolePrinter.SAVE_CHANGES);
                    if (view.wantToSave()) {
                        SavaDataController();
                    }
                    work = false;
                }
                case 1 -> {
                    try {
                        int minutes = view.countOfMinutes();
                        List<Subscriber> result = model.intracityMoreThen(minutes);
                        printer.printResult(result);
                        if (view.wantToSave()) {
                            saveResultToLocalFileController(result);
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        printer.print(ConsolePrinter.EMPTY_DATA);
                    }
                }
                case 2 -> {
                    try {
                        List<Subscriber> result = model.usedIntercityCommunication();
                        printer.printResult(result);
                        if (view.wantToSave()) {
                            saveResultToLocalFileController(result);
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                        printer.print(ConsolePrinter.EMPTY_DATA);
                    }
                }
                case 3 -> {
                    SavaDataController();
                }
                case 4 -> {
                    loadDataController();
                }
                case 5 -> {
                    model.loadTestData();
                    printer.print(ConsolePrinter.GENERATED);
                }
                case 6 -> {
                    printer.print(ConsolePrinter.ALL_DATA);
                    printer.printResult(model.getAllCustomersInSystem());
                }
            }
        } while (work);
    }
    private void saveResultToLocalFileController(List<Subscriber> subs){
        Path dir = view.getPath();
        try {
            DataManager.save(dir, subs);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            printer.print(ConsolePrinter.NOT_SAVED);
            printer.print(ConsolePrinter.CHECK_PATH);
            printer.print(ConsolePrinter.TRY_AGAIN);
        }
    }
    private void SavaDataController(){
        try {
            model.save();
            printer.print(ConsolePrinter.SAVED);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            printer.print(ConsolePrinter.NOT_SAVED);
            printer.print(ConsolePrinter.TRY_AGAIN);
        }
    }
    private void loadDataController(){
        try {
            model.load();
            printer.print(ConsolePrinter.LOADED);
        } catch (Exception e) {
            logger.fatal(e.getMessage(), e);
            printer.print(ConsolePrinter.NOT_LOADED);
            printer.print(ConsolePrinter.TRY_AGAIN);
        }
    }
}
