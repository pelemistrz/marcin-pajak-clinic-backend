package com.app.clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="doctors")
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String specialisation;

    @OneToMany(mappedBy = "doctor")
    private List<Visit> visits;

    @OneToMany(mappedBy = "doctor")
    private List<StaffEvaluation> staffEvaluations;

    @Embedded
    private Audit audit = new Audit();
}
