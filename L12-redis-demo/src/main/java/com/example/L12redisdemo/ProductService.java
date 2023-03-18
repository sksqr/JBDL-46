package com.example.L12redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    Map<Long,Product> productMap;

    @PostConstruct
    public void init(){
        productMap = new HashMap<>();
        productMap.put(1l,new Product(1l,"laptop",40000.00));
        productMap.put(2l,new Product(2l,"mobile",20000.00));
    }


    public Product getById(Long id){
        LOGGER.info("fetching from data source");
        return productMap.get(id);
    }
}
