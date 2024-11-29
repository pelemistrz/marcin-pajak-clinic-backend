package com.app.clinic.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable
public class Audit {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist() {
        createdOn = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
