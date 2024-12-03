package com.app.clinic.controller;

import com.app.clinic.model.dto.StaffEvaluationDto;
import com.app.clinic.service.StaffEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/evaluations")
public class StaffEvaluationController {
    private final StaffEvaluationService service;

    @GetMapping
    public ResponseEntity<List<StaffEvaluationDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
