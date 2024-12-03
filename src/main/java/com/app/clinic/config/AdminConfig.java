package com.app.clinic.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;
}
