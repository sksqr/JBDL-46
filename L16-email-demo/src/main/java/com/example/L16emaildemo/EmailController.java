package com.example.L16emaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping
    ResponseEntity<String> sendEmail(@RequestBody SendEmailRequest request){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setTo(request.getToEmail());
        simpleMailMessage.setText(request.getBody());
        simpleMailMessage.setCc(request.getCc());
        javaMailSender.send(simpleMailMessage);


        return ResponseEntity.ok("Done");
    }
}
