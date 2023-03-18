package com.example.L12springsecuritydemo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/{id}")
    ResponseEntity<Product> getById(@PathVariable Long id){
        Product      product = productService.getById(id);
        return ResponseEntity.ok(product);

    }

}
