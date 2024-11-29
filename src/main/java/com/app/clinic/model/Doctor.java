package com.app.clinic.model;

import com.app.clinic.model.dto.DoctorDto;
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

    public Doctor(String name, String surname, String specialisation) {
        this.name = name;
        this.surname = surname;
        this.specialisation = specialisation;
    }

    public void updateFrom(DoctorDto doctorDto) {
        this.name = doctorDto.getName();
        this.surname = doctorDto.getSurname();
        this.specialisation = doctorDto.getSpecialisation();
    }
}
