package com.example.L06springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    
    private List<Product> dataSource = new ArrayList<>();
    private long nextId = 1l;

    public void addProduct(Product product){
        product.setId(nextId);
        dataSource.add(product);
        nextId++;
    }
}
