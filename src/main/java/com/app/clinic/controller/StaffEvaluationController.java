package com.app.clinic.controller;

import com.app.clinic.exception.DoctorNotFoundException;
import com.app.clinic.exception.PatientNotFoundException;
import com.app.clinic.model.dto.StaffEvaluationDto;
import com.app.clinic.model.dto.projection.StaffEvaluationWriteDto;
import com.app.clinic.service.StaffEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/evaluations")
public class StaffEvaluationController {
    private final StaffEvaluationService service;

    @GetMapping
    public ResponseEntity<List<StaffEvaluationDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffEvaluationDto> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> addEvaluation(@RequestBody StaffEvaluationWriteDto source ) throws DoctorNotFoundException, PatientNotFoundException {
        service.save(source);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id){
        service.deleteEvaluationBy(id);
        return ResponseEntity.ok().build();
    }

}
