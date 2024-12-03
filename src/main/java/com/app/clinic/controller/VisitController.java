package com.app.clinic.controller;


import com.app.clinic.model.dto.VisitDto;
import com.app.clinic.repository.VisitRepository;
import com.app.clinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
