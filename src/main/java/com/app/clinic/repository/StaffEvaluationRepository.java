package com.app.clinic.repository;

import com.app.clinic.model.StaffEvaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffEvaluationRepository extends CrudRepository<StaffEvaluation, Long> {
    @Override
    List<StaffEvaluation> findAll();
}
