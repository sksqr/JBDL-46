package com.example.L08springjdbcdemo;

import java.util.List;

public interface IProductDAO {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Integer id);
}
