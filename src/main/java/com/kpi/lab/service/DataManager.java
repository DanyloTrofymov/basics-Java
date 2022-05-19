package com.kpi.lab.service;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.kpi.lab.model.entity.Subscriber;
import com.kpi.lab.model.SubscriberModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final Logger logger = LogManager.getLogger(SubscriberModel.class);
    public static Path getDefaultPath(){
        String dir = System.getProperty("user.dir") + System.getProperty("file.separator") + "server storage";
        return Paths.get(dir).resolve("storage.json");
    }

    public static void save(List<Subscriber> subs) throws Exception {
        save(getDefaultPath(), subs);
    }

    public static void save(Path path, List<Subscriber> subs) throws Exception {
        logger.info("Function \"save\" has called");
        JsonArray ja = new JsonArray();
        for(Subscriber sub: subs){
            ja.add(toJsonObject(sub));
        }
        String jsonText = Jsoner.serialize(ja);
        try {
            Files.write(path, jsonText.getBytes(), StandardOpenOption.CREATE);
        }catch (IOException e){
            logger.error(e.getMessage(), e);
            throw new IOException(e);
        }
    }

    public static List<Subscriber> load() throws Exception {
        return load(getDefaultPath());
    }
    public static List<Subscriber> load(Path path) throws Exception {
        logger.info("Function \"load\" has called");
        JsonArray ja;
        String jsonText;
        ArrayList<Subscriber> subs= new ArrayList<>();
        try {
            jsonText = new String(Files.readAllBytes(path));
            ja = (JsonArray)Jsoner.deserialize(jsonText);
            for(Object object: ja){
                JsonObject jo = (JsonObject) object;
                subs.add(fromJsonObject(jo));
            }
            return subs;
        }catch (Exception e){
            logger.fatal(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    public static Subscriber fromJsonObject(JsonObject jo){
        String firstName = (String) jo.get("First Name");
        String lastName = (String) jo.get("Last Name");
        String patronymic = (String) jo.get("Patronymic");
        String address = (String) jo.get("Address");
        int intercity = ((BigDecimal) jo.get("Intercity")).intValue();
        int intracity = ((BigDecimal) jo.get("Intracity")).intValue();
        return new Subscriber(firstName, lastName, patronymic, address, intercity, intracity);
    }

    public static JsonObject toJsonObject(Subscriber sub){
        JsonObject jo = new JsonObject();
        jo.put("First Name", sub.getFirstName());
        jo.put("Last Name", sub.getLastName());
        jo.put("Patronymic", sub.getPatronymic());
        jo.put("Address", sub.getAddress());
        jo.put("Intercity", sub.getIntercityTalk());
        jo.put("Intracity", sub.getIntracityTalk());
        return jo;
    }
    public static List<Subscriber> generateTestData() {
        List<Subscriber> subs= new ArrayList<>();
        for (int i = 0; i < SubscriberFactory.NUMBER_OF_SUBSCRIBERS; i++) {
            subs.add(SubscriberFactory.getSubscribernstance());
        }
        return subs;
    }
}
