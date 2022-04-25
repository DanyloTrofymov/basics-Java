package com.kpi.lab;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class SubscriberModel {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberModel.class);
    private final int NUMBER_OF_SUBSCRIBERS = 20;
    private ArrayList<Subscriber> allSubscribers;

    public SubscriberModel(){ this.allSubscribers = new ArrayList<>(); }

    public ArrayList<Subscriber> getAllCustomersInSystem() {
        return allSubscribers;
    }

    public void generateData(){
        allSubscribers.clear();
        for(int i = 0; i < NUMBER_OF_SUBSCRIBERS; i++){
            allSubscribers.add(SubscriberFactory.getSubscribernstance());
        }
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

    public Path getDefaultPath(){
        String home = System.getProperty("user.home");
        return Paths.get(home).resolve("storage.Json");
    }

    public void save(){
        save(getDefaultPath());
    }

    public void save(Path path){
        ArrayList<Subscriber> subs = getAllCustomersInSystem();
        JsonArray ja = new JsonArray();
        for(Subscriber sub: subs){
            ja.add(Subscriber.toJsonObject(sub));
        }
        String jsonText = Jsoner.serialize(ja);
        try {
            Files.write(path, jsonText.getBytes(), StandardOpenOption.CREATE);
        }catch (IOException e){
            logger.error(e.getMessage(), e);
            System.out.println("Saving error:" + e.getMessage());
        }
    }

    public void load(){
        load(getDefaultPath());
    }
    public void load(Path path){
        JsonArray ja = null;
        String jsonText = null;
        ArrayList<Subscriber> subs = new ArrayList<>();
        try {
            jsonText = new String(Files.readAllBytes(path));

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            System.out.println("Loading error:" + e.getMessage());
        }
        try {
            ja = (JsonArray)Jsoner.deserialize(jsonText);
        } catch (JsonException e) {
            logger.error(e.getMessage(), e);
            System.out.println("Loading error:" + e.getMessage());
        }

        for(Object object: ja){
            JsonObject jo = (JsonObject) object;
            subs.add(Subscriber.fromJsonObject(jo));
        }
        allSubscribers = subs;
    }
}
