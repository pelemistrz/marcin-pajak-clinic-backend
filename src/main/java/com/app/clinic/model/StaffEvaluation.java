package com.app.clinic.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="staff_evaluations")
@NoArgsConstructor
@Data
public class StaffEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_patient")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_doctor")
    private Doctor doctor;


    private String evaluation;

    @Embedded
    private Audit audit = new Audit();

    public StaffEvaluation(Patient patient, Doctor doctor, String evaluation) {
        this.patient = patient;
        this.doctor = doctor;
        this.evaluation = evaluation;
    }
}
