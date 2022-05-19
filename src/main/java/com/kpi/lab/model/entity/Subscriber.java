package com.kpi.lab.model.entity;
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
}
