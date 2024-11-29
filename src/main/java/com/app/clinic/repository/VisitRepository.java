package com.app.clinic.repository;

import com.app.clinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
    @Override
    List<Visit> findAll();
}
