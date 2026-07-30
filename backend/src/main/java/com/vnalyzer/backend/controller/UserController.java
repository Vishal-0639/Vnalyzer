package com.vnalyzer.backend.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vnalyzer.backend.model.User;
import com.vnalyzer.backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }
    //post
    @PostMapping
    public User createUser(@RequestBody User user){
        return service.createUser(user);

    }


    
}
