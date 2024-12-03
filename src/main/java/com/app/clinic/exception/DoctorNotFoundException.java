package com.app.clinic.exception;

public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException() {
        super("Doctor with given id has not been found");
    }
}
