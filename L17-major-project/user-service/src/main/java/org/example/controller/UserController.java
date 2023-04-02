package org.example.controller;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-service")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    ResponseEntity<Long> createUser(@RequestBody UserDto userDto){
        Long id = userService.createUser(userDto);
        return ResponseEntity.ok(id);
    }

}
