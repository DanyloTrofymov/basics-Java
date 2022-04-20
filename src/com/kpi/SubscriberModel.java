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

    public ArrayList<Subscriber> intracityMoreThen(int minutes){
        ArrayList<Subscriber> found = new ArrayList<Subscriber>();
        for(int i = 0; i < allSubscribers.size(); i++){
            Subscriber sub = allSubscribers.get(i);
            if(sub.getIntracityTalk() > minutes){
                found.add(sub);
            }
        }
        return found;
    }

    public ArrayList<Subscriber> usedIntercityCommunication(){
        ArrayList<Subscriber> found = new ArrayList<Subscriber>();
        for(int i = 0; i < allSubscribers.size(); i++){
            Subscriber sub = allSubscribers.get(i);
            if(sub.getIntercityTalk() > 0){
                found.add(sub);
            }
        }
        return found;
    }
}
