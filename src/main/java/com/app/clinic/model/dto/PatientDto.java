package com.app.clinic.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PatientDto {
    private String name;
    private String surname;
    private Long pesel;
    private Long phone;

    private LocalDate dateOfBirth;
}
