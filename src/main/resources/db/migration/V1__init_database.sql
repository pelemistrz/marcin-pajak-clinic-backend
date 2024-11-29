

CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    pesel BIGINT NOT NULL,
    phone BIGINT NOT NULL,
    date_of_birth DATE NOT NULL
);



CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    specialisation VARCHAR(255) NOT NULL
);



CREATE TABLE visits (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_patient BIGINT NULL,
    id_doctor BIGINT NOT NULL,
    date_visit DATETIME NOT NULL,
    description TEXT NOT NULL,
    CONSTRAINT visits_id_patient_foreign FOREIGN KEY(id_patient) REFERENCES patients(id),
    CONSTRAINT visits_id_doctor_foreign FOREIGN KEY(id_doctor) REFERENCES doctors(id)
);



CREATE TABLE staff_evaluations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_patient BIGINT NOT NULL,
    id_doctor BIGINT NOT NULL,
    evaluation TEXT NOT NULL,
    CONSTRAINT staff_evaluations_id_patient_foreign FOREIGN KEY(id_patient) REFERENCES patients(id),
    CONSTRAINT staff_evaluations_id_doctor_foreign FOREIGN KEY(id_doctor) REFERENCES doctors(id)
);