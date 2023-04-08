package org.example.service;

import org.example.dto.UserCreatedPayload;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static String USER_CREATED_TOPIC = "USER_CREATED";
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public Long createUser(UserDto userDto)  {
        User user = User.builder().name(userDto.getName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .kycId(userDto.getKycId())
                .address(userDto.getAddress())
                .build();
        userRepo.save(user);

        UserCreatedPayload payload = new UserCreatedPayload(user.getId(), user.getName(), user.getEmail(), MDC.get("requestId"));
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(USER_CREATED_TOPIC,String.valueOf(user.getId()),payload);
        try {
            LOGGER.info("Pushed data to kafka, response : {} ",future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return user.getId();
    }
}
