package com.example.L06springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppRestcontroller {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String getHello(@RequestParam("n") String name,  @RequestParam(name = "a", required = false) Integer age){
        return "Hello "+name+" " +age+" from "+Thread.currentThread().getName();
    }

    @GetMapping("/helloPath/{n}")
    public String getHelloPath(@PathVariable(name = "n") String name){
        return "Hello "+name+" from "+Thread.currentThread().getName();
    }

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody Product product){
        System.out.println(product);
        productService.addProduct(product);
        return "success";
    }
}
