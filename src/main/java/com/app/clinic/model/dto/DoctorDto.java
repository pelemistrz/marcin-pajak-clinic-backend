package com.app.clinic.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorDto {

    private String name;
    private String surname;
    private String specialisation;
}
