package com.app.clinic.exception;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException() {
        super("Patient with given id has not been found");
    }
}
