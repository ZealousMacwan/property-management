package com.zealous.propertymanagement.controller;

import com.zealous.propertymanagement.dto.UserDTO;
import com.zealous.propertymanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Register", description = "Post method for user registration")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(
            @ParameterObject UserDTO paramObjUserDTO,
            @Valid @RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
