package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.dto.TransactionCompPayload;
import org.example.dto.UserCreatedPayload;
import org.example.entity.Transaction;
import org.example.entity.TransactionStatus;
import org.example.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class TransactionKafkaConsumerConfig {


    private static Logger LOGGER = LoggerFactory.getLogger(TransactionKafkaConsumerConfig.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TransactionRepo transactionRepo;

    @KafkaListener(topics = "TXN_COMP", groupId = "txnApp")
    public void consumeFromTxnCompTopic(ConsumerRecord payload) throws JsonProcessingException {
        LOGGER.info("Getting payload from kafka: {}",payload);
        TransactionCompPayload transactionCompPayload = objectMapper.readValue(payload.value().toString(),TransactionCompPayload.class);
        MDC.put("requestId",transactionCompPayload.getRequestId());
        LOGGER.info("Getting transactionCompPayload from kafka: {}",transactionCompPayload);
        Transaction transaction = transactionRepo.findById(transactionCompPayload.getId()).get();
        if(transactionCompPayload.isSuccess()){
            transaction.setStatus(TransactionStatus.SUCCESS);
        }
        else{
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setReason(transactionCompPayload.getReason());
        }
        transactionRepo.save(transaction);
        MDC.clear();
    }
}
