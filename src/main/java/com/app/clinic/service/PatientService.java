package com.app.clinic.service;

import com.app.clinic.config.AdminConfig;
import com.app.clinic.mapper.PatientMapper;
import com.app.clinic.model.Mail;
import com.app.clinic.model.dto.DoctorDto;
import com.app.clinic.model.dto.PatientDto;
import com.app.clinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;



    public List<PatientDto> findAll() {
        return mapper.mapToPatientDtoList(repository.findAll());

    }

    public Optional<PatientDto> findById(Long id) {
        return repository.findById(id).map(mapper::mapToPatientDto);
    }

    public void save(PatientDto patientDto) {
        repository.save(mapper.mapToPatient(patientDto));
        emailService.send(new Mail(
                adminConfig.getAdminMail(),
                "Nowy Pacjent",
                "został dodany nowy Pacjent "+patientDto.getName()+" do bazy danych, pamietaj o zaoferowaniu nowych uslug"
        ));
    }

    public void deletePatientById(Long id) {
        repository.deleteById(id);
    }
}
