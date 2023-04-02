package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.WalletRepo;
import org.example.dto.UserCreatedPayload;
import org.example.entity.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    private WalletRepo walletRepo;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "USER_CREATED", groupId = "walletapp")
    public void consumeFromUserCreatedTopic(ConsumerRecord payload) throws JsonProcessingException {
        LOGGER.info("Getting payload from kafka: {}",payload);
        UserCreatedPayload userCreatedPayload = objectMapper.readValue(payload.value().toString(),UserCreatedPayload.class);
        LOGGER.info("Getting userCreatedPayload from kafka: {}",userCreatedPayload);
        Wallet wallet = Wallet.builder()
                .userId(userCreatedPayload.getUserId())
                .balance(100.00)
                .build();
        walletRepo.save(wallet);
    }
}
