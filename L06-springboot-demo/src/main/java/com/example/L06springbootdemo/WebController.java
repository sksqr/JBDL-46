package com.example.L06springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class WebController {

    @GetMapping("/time")
    @ResponseBody
    public String getTime(){
//        String msg = "test";
        String msg = new Date().toString();
        return msg;
    }
}
