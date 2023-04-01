package com.example.L16filterloggerdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    ResponseEntity<String> getHello(){
        LOGGER.info("Received request ");
        return ResponseEntity.ok("hello from "+Thread.currentThread().getName());
    }


    @GetMapping("/hi")
    ResponseEntity<String> getHi(){
        LOGGER.info("Received request ");
        return ResponseEntity.ok("Hi from "+Thread.currentThread().getName());
    }
}
