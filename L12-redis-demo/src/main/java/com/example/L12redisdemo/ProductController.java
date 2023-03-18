package com.example.L12redisdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate<String,Product> redisTemplate;


    @GetMapping("/{id}")
    ResponseEntity<Product> getById(@PathVariable Long id){
        String key ="product:"+id;
        Product product =  redisTemplate.opsForValue().get(key);
//        if(product == null){
//            product = productService.getById(id);
//            redisTemplate.opsForValue().set(key,product);
//        }
        return ResponseEntity.ok(product);

    }

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody Product product){
        Long nextId = redisTemplate.opsForValue().increment("nextProductId");
        product.setId(nextId);
        String key = "product:"+nextId;
        redisTemplate.opsForValue().set(key,product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Long id){
        String key = "product:"+id;
        redisTemplate.delete(key);
        return ResponseEntity.ok("Deleted");

    }
}
