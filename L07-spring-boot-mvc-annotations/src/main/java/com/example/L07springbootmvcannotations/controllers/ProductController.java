package com.example.L07springbootmvcannotations.controllers;

import com.example.L07springbootmvcannotations.models.Product;
import com.example.L07springbootmvcannotations.services.ProductService;
import org.gfg.keyword.KeywordAnalyzerInterface;
import org.gfg.keyword.UniqueKeywordAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("uniqueKeywordAnalyser")
    private KeywordAnalyzerInterface keywordAnalyzerInterface;

    @Value("${search.service.url}")
    private String url;

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    List<Product> getProductByKey(@RequestParam String keyword){
        keywordAnalyzerInterface.recordKeyword(keyword);
        return productService.getProducts();
    }

    @GetMapping("/keywords")
    List<String> getAllKeyword(){
        return keywordAnalyzerInterface.getAllKeyword();
    }

}
