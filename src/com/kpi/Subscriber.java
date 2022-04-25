package com.kpi;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.math.BigDecimal;

public class Subscriber {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private int intercityTalk;
    private int intracityTalk;

    public Subscriber(String firstName, String lastName, String patronymic, String address, int intercityTalk, int intracityTalk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.intercityTalk = intercityTalk;
        this.intracityTalk = intracityTalk;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public int getIntercityTalk() {
        return intercityTalk;
    }

    public int getIntracityTalk() {
        return intracityTalk;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIntercityTalk(int intercityTalk) {
        this.intercityTalk = intercityTalk;
    }

    public void setIntracityTalk(int intracityTalk) {
        this.intracityTalk = intracityTalk;
    }

    @Override
    public String toString() {
        return "Subscriber: \n" +
                "FirstName:" + firstName + '\n' +
                "LastName:" + lastName + '\n' +
                "Patronymic:" + patronymic + '\n' +
                "Address:" + address + '\n' +
                "IntercityTalk:" + intercityTalk + " mins \n" +
                "IntracityTalk:" + intracityTalk + " mins \n\n";
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
