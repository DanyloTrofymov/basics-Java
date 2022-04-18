package com.kpi;

import java.util.ArrayList;
import java.util.Scanner;

public class SubscriberView {
    private ConsolePrinter printer;

    public SubscriberView(ConsolePrinter printer) {
        this.printer = printer;
    }


    public int chooseFunction() {
        Scanner scanner = new Scanner(System.in);
        printer.printInputPleaseMsg();
        int functionType = scanner.nextInt();
        if (functionType == 1 || functionType == 2) {
            return functionType;
        } else {
            printer.printImpossibleFunction();
            return 0;
        }
    }

    public boolean toContinue() {
        Scanner scanner = new Scanner(System.in);
        printer.printWantToContinueMsg();
        int wantTo = scanner.nextInt();
        if(wantTo == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public int countOfMinutes() {
        Scanner scanner = new Scanner(System.in);
        printer.printCountOfMinutes();
        int minutes = scanner.nextInt();
        return minutes;
    }
    public void printArray(ArrayList<Subscriber> subs) {
        for(int i=0; i < subs.size(); i++){
            System.out.println(subs.get(i));
        }
    }
}
