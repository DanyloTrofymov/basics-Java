package com.kpi;

public class Main {

    public static void main(String[] args) {
        SubscriberView view = new SubscriberView();
        Subscriber[] subs = generateDemo();
        for (int i=0; i<subs.length; i++)
        {
            view.printSubscriber(subs[i]);
        }
    }

    public static Subscriber[] generateDemo(){
        Subscriber[] subs= new Subscriber[10];
        subs[0] = new Subscriber("Antony", "Baker", "Ivanovich", "Prospect myru", 10, 20);
        subs[1] = new Subscriber("Ohla", "Shevel", "Volodymirivna", "Peremohy street", 72, 54);
        subs[2] = new Subscriber("Dmytro", "Petrov", "Olexandrovych", "Prospect Bandery", 12, 4);
        subs[3] = new Subscriber("Olena", "Vasylenko", "Olehivna", "Vyshneva street", 200, 62);
        subs[4] = new Subscriber("Oleh", "Somehitov", "Vladyslavovych", "Khreshatyk Street", 10, 72);
        subs[5] = new Subscriber("Iryna", "Zusko", "Vitalivna", "Bessarabska Sqare", 12, 0);
        subs[6] = new Subscriber("Vladyslav", "Medvedev", "Petrovych", "Evropeyska street", 0, 72);
        subs[7] = new Subscriber("Maryna", "Kotova", "Vasylivna", "Prospect Dovzhenko", 0, 12);
        subs[8] = new Subscriber("Dave", "Panfilov", "Davydovych", "Lesy Ukrainky street", 42, 1);
        subs[9] = new Subscriber("Marry", "Jane", "Piterivna", "Baker street", 0, 53);
        return subs;
    }
}
