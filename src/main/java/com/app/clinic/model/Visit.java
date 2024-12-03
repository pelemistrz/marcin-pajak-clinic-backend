package com.app.clinic.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="visits")
@NoArgsConstructor
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_patient")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_doctor")
    private Doctor doctor;

    @Column(name="date_visit")
    private Date dateVisit;

    private String description;

    @Embedded
    private Audit audit = new Audit();

    public Visit(Patient patient, Doctor doctor, Date dateVisit, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateVisit = dateVisit;
        this.description = description;
    }
}
