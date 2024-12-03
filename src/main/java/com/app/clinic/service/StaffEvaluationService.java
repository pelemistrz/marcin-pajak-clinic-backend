package com.app.clinic.service;

import com.app.clinic.mapper.StaffEvaluationMapper;
import com.app.clinic.model.StaffEvaluation;
import com.app.clinic.model.dto.StaffEvaluationDto;
import com.app.clinic.repository.StaffEvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffEvaluationService {
    private final StaffEvaluationRepository repository;
    private final StaffEvaluationMapper mapper;


    public List<StaffEvaluationDto> findAll() {
        return mapper.mapToStaffEvaluationDtoList(repository.findAll());
    }
}
