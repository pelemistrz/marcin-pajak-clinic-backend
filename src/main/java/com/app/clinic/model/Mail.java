package com.app.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
    private String to;
    private String subject;
    private String content;
}
