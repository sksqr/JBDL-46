package com.gfg.L05demospringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        String msg = "Hello from spring-boot-demo thread:"+Thread.currentThread().getName();
        return msg;
    }

    @GetMapping("/getJobs")
    public String getJob(){
        String msg = "returning jobs from "+Thread.currentThread().getName();
        return msg;
    }

}
