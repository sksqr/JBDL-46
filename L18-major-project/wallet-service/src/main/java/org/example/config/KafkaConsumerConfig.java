package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.WalletRepo;
import org.example.dto.TransactionCompPayload;
import org.example.dto.TransactionInitPayload;
import org.example.dto.UserCreatedPayload;
import org.example.entity.Wallet;
import org.example.exception.InsufficientBalance;
import org.example.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private static String TXN_COMP_TOPIC= "TXN_COMP";

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private WalletService walletService;


    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "USER_CREATED", groupId = "walletapp")
    public void consumeFromUserCreatedTopic(ConsumerRecord payload) throws JsonProcessingException {
        LOGGER.info("Getting payload from kafka: {}",payload);
        UserCreatedPayload userCreatedPayload = objectMapper.readValue(payload.value().toString(),UserCreatedPayload.class);
        MDC.put("requestId",userCreatedPayload.getRequestId());
        LOGGER.info("Getting userCreatedPayload from kafka: {}",userCreatedPayload);
        Wallet wallet = Wallet.builder()
                .userId(userCreatedPayload.getUserId())
                .balance(100.00)
                .build();
        walletRepo.save(wallet);

        MDC.clear();
    }


    @KafkaListener(topics = "TXN_INIT", groupId = "walletapp")
    @Transactional
    public void consumeFromTxnInitTopic(ConsumerRecord payload) throws JsonProcessingException {
        LOGGER.info("Getting payload from kafka: {}",payload);
        TransactionInitPayload transactionInitPayload = objectMapper.readValue(payload.value().toString(),TransactionInitPayload.class);
        MDC.put("requestId",transactionInitPayload.getRequestId());
        LOGGER.info("Getting transactionInitPayload from kafka: {}",transactionInitPayload);
        TransactionCompPayload transactionCompPayload = new TransactionCompPayload();
        transactionCompPayload.setId(transactionInitPayload.getId());
        transactionCompPayload.setRequestId(transactionInitPayload.getRequestId());
        try {
            walletService.doWalletTxn(transactionInitPayload);
            transactionCompPayload.setSuccess(true);
        } catch (InsufficientBalance e) {
            transactionCompPayload.setSuccess(false);
            transactionCompPayload.setReason("Insufficient Balance");
        }
        catch (Exception exception){
            transactionCompPayload.setSuccess(false);
            transactionCompPayload.setReason("Server Error");
        }
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TXN_COMP_TOPIC,String.valueOf(transactionInitPayload.getFromUserId()),transactionCompPayload);
        try {
            LOGGER.info("Pushed data to kafka, response : {} ",future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        MDC.clear();
    }
}
