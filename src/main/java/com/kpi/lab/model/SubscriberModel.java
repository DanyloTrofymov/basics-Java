package com.kpi.lab;

import org.apache.log4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SubscriberModel {
    private static final Logger logger = Logger.getLogger(SubscriberModel.class);
    private List<Subscriber> allSubscribers;
    public SubscriberModel(){ this.allSubscribers = new ArrayList<>(); }

    public List<Subscriber> getAllCustomersInSystem() {
        return allSubscribers;
    }

    public void generateData(){
        allSubscribers.clear();
        for(int i = 0; i < SubscriberFactory.NUMBER_OF_SUBSCRIBERS; i++){
            allSubscribers.add(SubscriberFactory.getSubscribernstance());
        }
    }

    public List<Subscriber> intracityMoreThen(int minutes) throws Exception{
        Validator.validateIsDataPresent(allSubscribers);
        List<Subscriber> found = new ArrayList<>();
        for (Subscriber sub : allSubscribers) {
            if (sub.getIntracityTalk() > minutes) {
                found.add(sub);
            }
        }
        return found;
    }

    public List<Subscriber> usedIntercityCommunication() throws Exception{
        Validator.validateIsDataPresent(allSubscribers);
        List<Subscriber> found = new ArrayList<>();
        for (Subscriber sub : allSubscribers) {
            if (sub.getIntercityTalk() > 0) {
                found.add(sub);
            }
        }
        return found;
    }
    public void load() throws Exception {
        allSubscribers = DataManager.load();
    }
}
