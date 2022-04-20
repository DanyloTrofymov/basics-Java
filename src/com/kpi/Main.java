package com.kpi;

import com.kpi.exceptions.EmptyResultException;

public class Main {

    public static void main(String[] args) {
        SubscriberModel model = new SubscriberModel();
        ConsolePrinter printer = new ConsolePrinter();
        SubscriberView view = new SubscriberView(printer);
        SubscriberController controller = new SubscriberController(model, view);

        controller.start();

    }

}
