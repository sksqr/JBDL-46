package com.example.L16emaildemo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendEmailRequest {

    private String toEmail;

    private String subject;

    private String body;

    private String cc;
}
