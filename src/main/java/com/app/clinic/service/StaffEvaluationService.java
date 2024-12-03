package com.app.clinic.service;

import com.app.clinic.exception.DoctorNotFoundException;
import com.app.clinic.exception.PatientNotFoundException;
import com.app.clinic.mapper.StaffEvaluationMapper;
import com.app.clinic.model.Doctor;
import com.app.clinic.model.Patient;
import com.app.clinic.model.StaffEvaluation;
import com.app.clinic.model.Visit;
import com.app.clinic.model.dto.StaffEvaluationDto;
import com.app.clinic.model.dto.projection.StaffEvaluationWriteDto;
import com.app.clinic.repository.DoctorRepository;
import com.app.clinic.repository.PatientRepository;
import com.app.clinic.repository.StaffEvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffEvaluationService {
    private final StaffEvaluationRepository repository;
    private final StaffEvaluationMapper mapper;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;


    public List<StaffEvaluationDto> findAll() {
        return mapper.mapToStaffEvaluationDtoList(repository.findAll());
    }

    public Optional<StaffEvaluationDto> findById(Long id) {
        return repository.findById(id).map(mapper::mapToStaffEvaluationDto);
    }

    public void save(StaffEvaluationWriteDto source) throws DoctorNotFoundException, PatientNotFoundException {
        Patient patient = patientRepository.findById(source.getPatientId()).orElseThrow(PatientNotFoundException::new);
        Doctor doctor = doctorRepository.findById(source.getDoctorId()).orElseThrow(DoctorNotFoundException::new);
        StaffEvaluation staffEvaluation = new StaffEvaluation(patient, doctor,source.getEvaluation());
        repository.save(staffEvaluation);
    }

    public void deleteEvaluationBy(Long id) {
        repository.deleteById(id);
    }
}
