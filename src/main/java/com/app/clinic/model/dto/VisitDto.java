package com.app.clinic.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class VisitDto {

    private PatientDto patient;

    private DoctorDto doctor;

    private Date dateVisit;

    private String description;
}
