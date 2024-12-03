package com.app.clinic.controller;

import com.app.clinic.exception.DoctorNotFoundException;
import com.app.clinic.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handlePatientNotFoundException(PatientNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
