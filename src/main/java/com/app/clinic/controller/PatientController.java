package com.app.clinic.controller;


import com.app.clinic.model.dto.DoctorDto;
import com.app.clinic.model.dto.PatientDto;
import com.app.clinic.repository.PatientRepository;
import com.app.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientRepository repository;
    private final PatientService service;

    @GetMapping
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> addPatient(@RequestBody PatientDto patientDto) {
        service.save(patientDto);
        return ResponseEntity.ok().build();
    }

     //put mapping



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        service.deletePatientById(id);
        return ResponseEntity.ok().build();
    }
}
