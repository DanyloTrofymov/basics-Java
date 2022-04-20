package com.kpi;

import com.kpi.exceptions.EmptyResultException;

public class SubscriberController {
    private SubscriberModel model;
    private SubscriberView view;

    public SubscriberController(SubscriberModel model, SubscriberView view){
        this.model = model;
        this.view = view;
    }

    public void start() {
        do {
            int func = view.chooseFunction();
            if(func == 0){
                break;
            }
            else if(func == 1){
                int minutes = view.countOfMinutes();
                if(minutes == -1){
                    view.getPrinter().printTryAgain();
                    continue;
                }
                view.printArray(model.intracityMoreThen(minutes));
            }
            else if(func == 2){
                view.printArray(model.usedIntercityCommunication());
            }
        }while (true);
    }
}
