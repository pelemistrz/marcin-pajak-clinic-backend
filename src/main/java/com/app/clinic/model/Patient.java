package com.app.clinic.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="patients")
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Long pesel;
    private Long phone;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "patient")
    private List<Visit> visits;

    @OneToMany(mappedBy = "patient")
    private List<StaffEvaluation> staffEvaluations;

    @Embedded
    private Audit audit = new Audit();
}
