package com.vnalyzer.backend.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.vnalyzer.backend.model.User;
import com.vnalyzer.backend.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }
    //post
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return service.createUser(user);

    }
    //get
    @GetMapping
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    //getbyid
    @GetMapping("/{id}")
    public User getUSerById(@PathVariable Long id){
        return service.getUserById(id);
    }
    //updatebyid
    @PutMapping("/{id}")
    public User updateById(@PathVariable Long id,@Valid @RequestBody User userdetails){
        return service.updateById(id,userdetails);
    }
    //deleteByid
    @DeleteMapping("/{id}")
    public void deleterUserById(@PathVariable Long id){
        service.deleteUserById(id);
    }


    
}
