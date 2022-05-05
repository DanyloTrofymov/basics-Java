package com.kpi.lab.service;

import com.kpi.lab.entity.Subscriber;

import java.util.Random;

public class SubscriberFactory {
    private static final String[] POSSIBLE_FIRST_NAMES;
    private static final String[] POSSIBLE_SECOND_NAMES;
    private static final String[] POSSIBLE_PATRONYMIC;
    private static final String[] POSSIBLE_ADDRESSES;
    public static final int NUMBER_OF_SUBSCRIBERS = 20;

    static{
        POSSIBLE_FIRST_NAMES = new String[]{
                "Antony", "Ohla", "Dmytro",
                "Olena", "Oleh", "Iryna",
                "Vladyslav", "Maryna", "Dave", "Marry"
        };

        POSSIBLE_SECOND_NAMES = new String[]{
                "Baker", "Shevel", "Petrov",
                "Vasylenko", "Somehitov", "Zusko",
                "Medvedev", "Kotova", "Panfilov", "JANE"
        };

        POSSIBLE_PATRONYMIC = new String[]{
                "Ivanovich", "Volodymirivna", "Olexandrovych",
                "Olehivna", "Vladyslavovych", "Vitalivna",
                "Petrovych", "Vasylivna", "Davydovych", "Piterivna"
        };

        POSSIBLE_ADDRESSES = new String[]{
                "Prospect myru", "Peremohy street", "Prospect Bandery",
                "Vyshneva street", "Khreshatyk Street", "Bessarabska Sqare",
                "Evropeyska street", "Prospect Dovzhenko", "Lesy Ukrainky street", "Baker street"
        };
    }

    public static Subscriber getSubscribernstance(){
        Random random = new Random();
        String firstName;
        String secondName;
        String patronymic;
        String address;
        int intercityTalk;
        int intracityTalk;

        int firstNameIndex = Math.abs( random.nextInt() ) % POSSIBLE_FIRST_NAMES.length;
        int secondNameIndex = Math.abs( random.nextInt() ) % POSSIBLE_SECOND_NAMES.length;
        int patronymicIndex = Math.abs( random.nextInt() ) % POSSIBLE_PATRONYMIC.length;
        int addressIndex = Math.abs( random.nextInt() ) % POSSIBLE_ADDRESSES.length;

        firstName = POSSIBLE_FIRST_NAMES[ firstNameIndex ];
        secondName = POSSIBLE_SECOND_NAMES[ secondNameIndex ];
        patronymic = POSSIBLE_PATRONYMIC[ patronymicIndex ];
        address = POSSIBLE_ADDRESSES[ addressIndex ];
        intercityTalk = Math.abs( random.nextInt() ) % 100;
        intracityTalk = Math.abs( random.nextInt() ) % 100;

        return new Subscriber(
                firstName,
                secondName,
                patronymic,
                address,
                intercityTalk,
                intracityTalk
        );
    }
}
