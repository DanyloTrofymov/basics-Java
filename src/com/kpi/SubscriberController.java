package com.kpi;

import java.util.ArrayList;

public class SubscriberController {
    private SubscriberModel model;
    private SubscriberView view;

    public SubscriberController(SubscriberModel model, SubscriberView view){
        this.model = model;
        this.view = view;
    }

    public void start(){
        do {
            int func = view.chooseFunction();
            if(func == 1){
                int minutes = view.countOfMinutes();
                view.printArray(intracityMoreThen(minutes));
            }
            else if(func == 2){
                view.printArray(usedIntercityCommunication());
            }
        }while (view.toContinue());
    }

    private ArrayList<Subscriber> intracityMoreThen(int minutes){
        ArrayList<Subscriber> all = model.getAllCustomersInSystem();
        ArrayList<Subscriber> found = new ArrayList<Subscriber>();
        for(int i = 0; i < all.size(); i++){
            Subscriber sub = all.get(i);
            if(sub.getIntracityTalk() > minutes){
                found.add(sub);
            }
        }
        return found;
    }

    private ArrayList<Subscriber> usedIntercityCommunication(){
        ArrayList<Subscriber> all = model.getAllCustomersInSystem();
        ArrayList<Subscriber> found = new ArrayList<Subscriber>();
        for(int i = 0; i < all.size(); i++){
            Subscriber sub = all.get(i);
            if(sub.getIntercityTalk() > 0){
                found.add(sub);
            }
        }
        return found;
    }
}
