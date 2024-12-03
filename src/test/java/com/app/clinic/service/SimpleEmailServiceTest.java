package com.app.clinic.service;

import com.app.clinic.model.Mail;
import org.hibernate.sql.ast.tree.expression.Over;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceTest {
    @Mock
    private JavaMailSender mailSender;
    @InjectMocks
    private SimpleEmailService simpleEmailService;
    @Test
    public void shouldSendEmail(){
        //given
        Mail mail = new Mail("test@test.com", "test", "test");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        //when
        simpleEmailService.send(mail);
        //then
        verify(mailSender,times(1)).send(message);
    }

}