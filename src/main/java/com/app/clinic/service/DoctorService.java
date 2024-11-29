package com.app.clinic.service;

import com.app.clinic.mapper.DoctorMapper;
import com.app.clinic.model.Doctor;
import com.app.clinic.model.dto.DoctorDto;
import com.app.clinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;
    private final DoctorMapper mapper;


    public List<DoctorDto> findAll() {
        return mapper.mapToDoctorDtoList(repository.findAll());

    }

    public Optional<DoctorDto> findById(Long id) {
        return repository.findById(id).map(mapper::mapToDoctorDto);
    }

    public void save(DoctorDto doctorDto) {
        repository.save(mapper.mapToDoctor(doctorDto));
    }

    public void deleteDoctorById(Long id) {
        repository.deleteById(id);
    }
}
