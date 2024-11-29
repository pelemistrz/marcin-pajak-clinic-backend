package com.app.clinic.repository;

import com.app.clinic.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Override
    List<Patient> findAll();
}
