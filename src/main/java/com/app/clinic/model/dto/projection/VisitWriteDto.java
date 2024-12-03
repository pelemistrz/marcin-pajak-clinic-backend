package com.app.clinic.model.dto.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class VisitWriteDto {
    private Long doctorId;
    private Long patientId;
    private Date dateVisit;

    private String description;
}
