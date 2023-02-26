package com.example.L08springjdbcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductRestController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product productRequest) throws URISyntaxException {
        Product product = productService.createProduct(productRequest);
        URI uri = new URI("/v1/product/"+product.getId());
        return ResponseEntity.created(uri).build();
        //return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){

        LOGGER.info("Received request for id {}",id);

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
