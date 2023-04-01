package com.example.L16kafkademo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String,Product> productKafkaTemplate;

    @PostMapping
    public ResponseEntity<String> pushDataToKafka(@RequestParam String data) throws ExecutionException, InterruptedException {
        String topic = "topic02";
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic,data);
//        LOGGER.info("Pushed data to kafka, kafka response : {}",future.get());
        return ResponseEntity.ok("Done");
    }


    @PostMapping("/product")
    public ResponseEntity<Product> pushDataToKafka(@RequestBody Product product) throws ExecutionException, InterruptedException {
        String topic = "topic03";
//        ListenableFuture<SendResult<String, Product>> future = productKafkaTemplate.send(topic,product);
        ListenableFuture<SendResult<String, Product>> future = productKafkaTemplate.send(topic,String.valueOf(product.getId()),product);
        LOGGER.info("Pushed data to kafka, kafka response : {}",future.get());
        return ResponseEntity.ok(product);
    }

}
