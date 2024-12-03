package com.app.clinic.scheduler;

import com.app.clinic.config.AdminConfig;
import com.app.clinic.model.Mail;
import com.app.clinic.repository.PatientRepository;
import com.app.clinic.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private final SimpleEmailService emailService;
    private final PatientRepository repository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendEmail() {
        Integer size = repository.findAll().size();
        emailService.send(new Mail(
                adminConfig.getAdminMail(),
                "Ilosc pacjentow",
                "Ilosc pacjentow wynosi "+size
        ));
    }
}
