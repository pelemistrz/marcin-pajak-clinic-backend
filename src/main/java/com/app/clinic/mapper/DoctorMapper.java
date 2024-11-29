package com.app.clinic.mapper;

import com.app.clinic.model.Doctor;
import com.app.clinic.model.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DoctorMapper {

    public DoctorDto mapToDoctorDto(Doctor doctor) {
        return new DoctorDto(doctor.getName(), doctor.getSurname(), doctor.getSpecialisation());
    }

    public List<DoctorDto> mapToDoctorDtoList(List<Doctor> doctors) {
        return doctors.stream()
                .map(this::mapToDoctorDto)
                .collect(toList());
    }

    public Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getName(),doctorDto.getSurname(),doctorDto.getSpecialisation());
    }
}
