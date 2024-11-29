package com.app.clinic.mapper;


import com.app.clinic.model.Patient;
import com.app.clinic.model.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PatientMapper {
    public PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(patient.getName(), patient.getSurname(), patient.getPesel(), patient.getPhone(), patient.getDateOfBirth());
    }

    public List<PatientDto> mapToPatientDtoList(List<Patient> patients) {
        return patients.stream()
                .map(this::mapToPatientDto)
                .collect(toList());
    }
    public Patient mapToPatient(PatientDto patientDto) {
        return new Patient(patientDto.getName(), patientDto.getSurname(), patientDto.getPesel(), patientDto.getPhone(), patientDto.getDateOfBirth());
    }
}
