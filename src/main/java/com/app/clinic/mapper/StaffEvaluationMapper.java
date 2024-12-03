package com.app.clinic.mapper;

import com.app.clinic.model.StaffEvaluation;
import com.app.clinic.model.dto.StaffEvaluationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class StaffEvaluationMapper {
    private final PatientMapper patientMapper;
    private final DoctorMapper doctorMapper;

    public StaffEvaluationDto mapToStaffEvaluationDto(StaffEvaluation staffEvaluation) {
        return new StaffEvaluationDto(
                patientMapper.mapToPatientDto(staffEvaluation.getPatient()),
                doctorMapper.mapToDoctorDto(staffEvaluation.getDoctor()),
                staffEvaluation.getEvaluation()
        );
    }

    public List<StaffEvaluationDto> mapToStaffEvaluationDtoList(List<StaffEvaluation> staffEvaluationList) {
        return staffEvaluationList.stream()
                .map(this::mapToStaffEvaluationDto)
                .collect(toList());
    }
}
