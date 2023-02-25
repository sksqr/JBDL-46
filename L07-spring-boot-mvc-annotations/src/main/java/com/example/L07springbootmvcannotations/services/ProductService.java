package com.example.L07springbootmvcannotations.services;


import com.example.L07springbootmvcannotations.models.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        productList=new ArrayList<>();
        productList.add(new Product(1,"laptop",3000.00));
        productList.add(new Product(2,"mobile",30.00));
        productList.add(new Product(3, "pen drive",30.00));
    }

    private int nextId=4;

    public List<Product> getProducts(){
        return productList;
    }

    public Product createProduct(Product product ){
        nextId++;
        product.setId(nextId);
        productList.add(product);
        return product;
    }

    public Product getbyId(Integer id){
        Product result = null;
        for(Product product : productList){
            if(product.getId() == id){
                result = product;
            }
        }
        return result;
    }

    public Product delete(Integer id){
        Product result = null;
        for(Product product : productList){
            if(product.getId() == id){
                result = product;
            }
        }
        productList.remove(result);
        return result;
    }

    public Product update(Integer id, Product productToUpdate){
        Product result = null;
        for(Product product : productList){
            if(product.getId() == id){
                result = product;
            }
        }
        if(result != null){
            result.setName(productToUpdate.getName());
            result.setPrice(productToUpdate.getPrice());
        }
        return result;
    }



}
