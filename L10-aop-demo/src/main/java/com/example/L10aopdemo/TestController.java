package com.example.L10aopdemo;


import com.example.L10aopdemo.aop.ExecutionTimeAspect;
import com.example.L10aopdemo.aop.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);


    @GetMapping
    @LogExecutionTime
    public String hello(){
        logger.info("Executing hello method");
        return "Hello!";
    }
}
