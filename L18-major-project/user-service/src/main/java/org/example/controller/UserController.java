package org.example.controller;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user-service")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    ResponseEntity<Long> createUser(@RequestBody UserDto userDto){
        LOGGER.info("Request received to createUser:  {}", userDto.getEmail());
        Long id = userService.createUser(userDto);
        return ResponseEntity.ok(id);
    }
}
