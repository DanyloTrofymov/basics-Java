package com.kpi.lab.model;

import com.kpi.lab.service.DataManager;
import com.kpi.lab.entity.Subscriber;
import com.kpi.lab.service.Validator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SubscriberModel {
    private static final Logger logger = Logger.getLogger(SubscriberModel.class);
    private List<Subscriber> allSubscribers;
    public SubscriberModel(){ this.allSubscribers = new ArrayList<>(); }

    public List<Subscriber> getAllCustomersInSystem() {
        return allSubscribers;
    }

    public void loadTestData(){
        allSubscribers = DataManager.generateTestData();
    }
    public List<Subscriber> intracityMoreThen(int minutes) throws Exception {
        logger.info("Function \"intracityMoreThen\" has called");
        try {
            Validator.validateIsDataPresent(allSubscribers);
            List<Subscriber> found = new ArrayList<>();
            for (Subscriber sub : allSubscribers) {
                if (sub.getIntracityTalk() > minutes) {
                    found.add(sub);
                }
            }
            return found;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Subscriber> usedIntercityCommunication() throws Exception {
        logger.info("Function \"usedIntercityCommunication\" has called");
        try {
            Validator.validateIsDataPresent(allSubscribers);
            List<Subscriber> found = new ArrayList<>();
            for (Subscriber sub : allSubscribers) {
                if (sub.getIntercityTalk() > 0) {
                    found.add(sub);
                }
            }
            return found;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    public void load() throws Exception {
        allSubscribers = DataManager.load();
    }
}
