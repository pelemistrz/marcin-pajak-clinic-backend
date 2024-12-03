package com.app.clinic.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class StaffEvaluationDto {

    private PatientDto patient;
    private DoctorDto doctor;
    private String evaluation;
}
