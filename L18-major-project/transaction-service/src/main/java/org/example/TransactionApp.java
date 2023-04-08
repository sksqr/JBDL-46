package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example","org.commonlib"})
public class TransactionApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(TransactionApp.class);
    }
}