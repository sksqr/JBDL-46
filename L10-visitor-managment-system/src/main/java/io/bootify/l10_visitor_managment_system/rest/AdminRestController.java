package io.bootify.l10_visitor_managment_system.rest;


import io.bootify.l10_visitor_managment_system.model.UserDTO;
import io.bootify.l10_visitor_managment_system.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/createUser")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UserDTO userDTO) {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
    }


    @PutMapping("markInactive/{id}")
    public ResponseEntity<Void> markInactive(@PathVariable(name = "id") final Long id) {
        userService.markInactive(id);
        return ResponseEntity.ok().build();
    }

    // upload CSV to create user



}
