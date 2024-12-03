package com.app.clinic.service;

import com.app.clinic.mapper.DoctorMapper;
import com.app.clinic.mapper.PatientMapper;
import com.app.clinic.model.Visit;
import com.app.clinic.model.dto.VisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class VisitMapper {
    private final PatientMapper patientMapper;
    private final DoctorMapper doctorMapper;

    public VisitDto mapToVisitDto(Visit visit) {
        return new VisitDto(
                patientMapper.mapToPatientDto(visit.getPatient()),
                doctorMapper.mapToDoctorDto(visit.getDoctor()),
                visit.getDateVisit(),
                visit.getDescription()
                );
    }
    public List<VisitDto> mapToVisitDtoList(List<Visit> visitList) {
        return visitList.stream()
                .map(this::mapToVisitDto)
                .collect(toList());
    }
}
