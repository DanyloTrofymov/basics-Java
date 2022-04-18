package com.kpi;

import java.util.ArrayList;

public class SubscriberModel {

    private final int NUMBER_OF_SUBSCRIBERS = 20;
    private ArrayList<Subscriber> allSubscribers = new ArrayList<Subscriber>();

    public SubscriberModel(){ this.allSubscribers = fetchData(); }

    public ArrayList<Subscriber> getAllCustomersInSystem() {
        return allSubscribers;
    }

    private ArrayList<Subscriber> fetchData(){
        for(int i = 0; i < NUMBER_OF_SUBSCRIBERS; i++){
            allSubscribers.add(SubscriberFactory.getSubscribernstance());
        }
        return allSubscribers;
    }
}
