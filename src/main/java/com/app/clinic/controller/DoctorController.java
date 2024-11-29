package com.app.clinic.controller;

import com.app.clinic.model.dto.DoctorDto;
import com.app.clinic.repository.DoctorRepository;
import com.app.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService service;
    private final DoctorRepository repository;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDto doctorDto) {
        service.save(doctorDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDoctor(@PathVariable Long id,@RequestBody DoctorDto doctorDto) {
        if(repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id).ifPresent(doctor->{
            doctor.updateFrom(doctorDto);
            repository.save(doctor);
        });
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        service.deleteDoctorById(id);
        return ResponseEntity.ok().build();
    }

}
