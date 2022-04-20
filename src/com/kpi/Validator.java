package com.kpi;

import com.kpi.exceptions.EmptyResultException;
import com.kpi.exceptions.WrongFunctionException;
import com.kpi.exceptions.WrongInputNumberException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validatePositiveNumbersInput(String num) throws WrongInputNumberException {
        Pattern p = Pattern.compile("^[1-9]+[0-9]*$");
        Matcher m = p.matcher(num);
        if (m.matches() || num.equals("0"))
            return;
        throw new WrongInputNumberException();
    }

    public static void checkFunctionType(int num) throws WrongFunctionException {
        if (!(num == 1 || num == 2 || num == 0)) {
            throw new WrongFunctionException();
        }
    }

    public static void checkResult(ArrayList<Subscriber> subs) throws EmptyResultException {
        if (subs.isEmpty()) {
            throw new EmptyResultException();
        }
    }
}
