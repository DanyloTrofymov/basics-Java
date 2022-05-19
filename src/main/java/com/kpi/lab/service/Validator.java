package com.kpi.lab.service;

import com.kpi.lab.model.entity.Subscriber;
import com.kpi.lab.model.exceptions.NoDataException;
import com.kpi.lab.model.exceptions.WrongFileFormatException;
import com.kpi.lab.model.exceptions.WrongFunctionException;
import com.kpi.lab.model.exceptions.NegativeNumberException;

import java.util.List;

public class Validator {
    public static void validatePositiveNumbersInput(int num) throws NegativeNumberException {
        if (num < 0)
            throw new NegativeNumberException();
    }

    public static void validateFunctionType(int num) throws WrongFunctionException {
        if (num < 0 || num > 6) {
            throw new WrongFunctionException();
        }
    }

    public static void validateFileFormat(String dir) {
        if (dir.length() < 5) {
            throw new WrongFileFormatException();
        }
        String format = dir.substring(dir.length() - 5);
        System.out.println(format);
        if (!format.equalsIgnoreCase(".json")) {
            throw new WrongFileFormatException();
        }
    }
    public static void validateIsDataPresent(List<Subscriber> sub) {
        if(sub.isEmpty()){
            throw new NoDataException();
        }
    }
}
