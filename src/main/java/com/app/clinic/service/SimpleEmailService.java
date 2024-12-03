package com.app.clinic.service;

import com.app.clinic.model.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleEmailService {
    private final JavaMailSender mailSender;

    public void send(Mail mail) {
        try {
            var message = createMessage(mail);
            mailSender.send(message);
            log.info("Email sent successfully");
        } catch (MailException e) {
            log.error("Failed to processs email sending: " + e.getMessage());
        }
    }

    private SimpleMailMessage createMessage(final Mail mail) {
        var message = new SimpleMailMessage();
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        return message;
    }
}
