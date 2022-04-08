package com.kpi;

public class SubscriberController {
    private Subscriber model;
    private SubscriberView view;

    public SubscriberController(Subscriber model, SubscriberView view){
        this.model = model;
        this.view = view;
    }

    public String getFirstName() {
        return model.getFirstName();
    }

    public String getLastName() {
        return model.getLastName();
    }

    public String getPatronymic() {
        return model.getPatronymic();
    }

    public String getAddress() {
        return model.getAddress();
    }

    public int getIntercityTalk() {
        return model.getIntercityTalk();
    }

    public int getIntracityTalk() {
        return model.getIntracityTalk();
    }

    public void setFirstName(String firstName) {
        model.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
            model.setLastName(lastName);
    }

    public void setPatronymic(String patronymic) {
        model.setPatronymic(patronymic);
    }

    public void setAddress(String address) {
        model.setAddress(address);
    }

    public void setIntercityTalk(int intercityTalk) {
        if(intercityTalk >= 0) {
            model.setIntercityTalk(intercityTalk);
        }
    }

    public void setIntracityTalk(int intracityTalk) {
        if(intracityTalk >= 0) {
            model.setIntracityTalk(intracityTalk);
        }
    }
}
