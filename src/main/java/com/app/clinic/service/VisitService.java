package com.app.clinic.service;

import com.app.clinic.exception.DoctorNotFoundException;
import com.app.clinic.exception.PatientNotFoundException;
import com.app.clinic.model.Doctor;
import com.app.clinic.model.Patient;
import com.app.clinic.model.Visit;
import com.app.clinic.model.dto.VisitDto;
import com.app.clinic.model.dto.projection.VisitWriteDto;
import com.app.clinic.repository.DoctorRepository;
import com.app.clinic.repository.PatientRepository;
import com.app.clinic.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository repository;
    private final VisitMapper mapper;

    public List<VisitDto> findAll() {
        return mapper.mapToVisitDtoList(repository.findAll());
    }

    public Optional<VisitDto> findById(Long id) {
        return repository.findById(id).map(mapper::mapToVisitDto);
    }

    public void save(VisitWriteDto visitWriteDto) throws PatientNotFoundException, DoctorNotFoundException {
        Patient patient = patientRepository.findById(visitWriteDto.getPatientId()).orElseThrow(PatientNotFoundException::new);
        Doctor doctor = doctorRepository.findById(visitWriteDto.getDoctorId()).orElseThrow(DoctorNotFoundException::new);
        Visit visit = new Visit(patient, doctor, visitWriteDto.getDateVisit(), visitWriteDto.getDescription());
        repository.save(visit);
    }
}
