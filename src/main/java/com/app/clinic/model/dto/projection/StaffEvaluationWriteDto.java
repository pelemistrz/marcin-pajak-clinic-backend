package com.app.clinic.model.dto.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StaffEvaluationWriteDto {

    private Long doctorId;
    private Long patientId;

    private String evaluation;
}
