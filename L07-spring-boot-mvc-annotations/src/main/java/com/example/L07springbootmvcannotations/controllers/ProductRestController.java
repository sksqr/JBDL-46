package com.example.L07springbootmvcannotations.controllers;

import com.example.L07springbootmvcannotations.models.Product;
import com.example.L07springbootmvcannotations.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product productRequest) throws URISyntaxException {
        Product product = productService.createProduct(productRequest);
        URI uri = new URI("/v1/product/"+product.getId());
        return ResponseEntity.created(uri).build();
        //return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product =  productService.getbyId(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id){
        Product product =  productService.delete(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productRequest){
        Product product =  productService.update(id,productRequest);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

}
