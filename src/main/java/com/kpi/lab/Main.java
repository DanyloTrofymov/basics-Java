package com.kpi.lab;

import com.kpi.lab.controller.SubscriberController;
import com.kpi.lab.model.SubscriberModel;
import com.kpi.lab.service.DataManager;
import com.kpi.lab.view.ConsolePrinter;
import com.kpi.lab.view.SubscriberView;

public class Main {
    public static void main(String[] args) {
        SubscriberModel model = new SubscriberModel();
        ConsolePrinter printer = new ConsolePrinter();
        SubscriberView view = new SubscriberView(printer);
        SubscriberController controller = new SubscriberController(model, view, printer);

        controller.start();
    }
}
