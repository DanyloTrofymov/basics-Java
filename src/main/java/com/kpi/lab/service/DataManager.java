package com.kpi.lab.service;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.kpi.lab.Subscriber;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static Path getDefaultPath(){
        String dir = System.getProperty("user.dir") + System.getProperty("file.separator") + "server storage";
        return Paths.get(dir).resolve("storage.json");
    }

    public static void save(List<Subscriber> subs) throws Exception {
        save(getDefaultPath(), subs);
    }

    public static void save(Path path, List<Subscriber> subs) throws Exception {
        JsonArray ja = new JsonArray();
        for(Subscriber sub: subs){
            ja.add(toJsonObject(sub));
        }
        String jsonText = Jsoner.serialize(ja);
        try {
            Files.write(path, jsonText.getBytes(), StandardOpenOption.CREATE);
        }catch (IOException e){
            throw new Exception(e);
        }
    }

    public static List<Subscriber> load() throws Exception {
        return load(getDefaultPath());
    }
    public static List<Subscriber> load(Path path) throws Exception {
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
}
