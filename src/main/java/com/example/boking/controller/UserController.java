package com.example.boking.controller;

import com.example.boking.model.User;
import com.example.boking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


}
