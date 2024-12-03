package com.app.clinic.controller;


import com.app.clinic.exception.DoctorNotFoundException;
import com.app.clinic.exception.PatientNotFoundException;
import com.app.clinic.model.dto.VisitDto;
import com.app.clinic.model.dto.projection.VisitWriteDto;
import com.app.clinic.repository.VisitRepository;
import com.app.clinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/visits")
public class VisitController {
    private final VisitRepository repository;
    private final VisitService service;

    @GetMapping
    public ResponseEntity<List<VisitDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDto> findById(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> addVisit(@RequestBody VisitWriteDto visitWriteDto) throws PatientNotFoundException, DoctorNotFoundException {
        service.save(visitWriteDto);
        return ResponseEntity.ok().build();
    }
}
