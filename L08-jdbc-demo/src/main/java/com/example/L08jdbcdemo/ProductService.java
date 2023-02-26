package com.example.L08jdbcdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    private List<Product> productList;

    public ProductService() {
        productList=new ArrayList<>();
        productList.add(new Product(1,"laptop",3000.00));
        productList.add(new Product(2,"mobile",30.00));
        productList.add(new Product(3, "pen drive",30.00));
    }

    private int nextId=4;

    public List<Product> getProducts(){
        return productDAO.getAllProduct();
    }

    public Product createProduct(Product product ){
        //productDAO.createProduct(product);
        //productDAO.createProductWithPrepared(product);
        productDAO.createProductInTxn(product);
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
