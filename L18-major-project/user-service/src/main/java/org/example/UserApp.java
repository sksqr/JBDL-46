package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.commonlib", "org.example"})
public class UserApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(UserApp.class);
    }
}