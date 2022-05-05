package com.kpi.lab.exceptions;

public class FileFormatError extends RuntimeException{
    public FileFormatError() {super("Wrong file format!"); }
}
