package com.vnalyzer.backend.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.vnalyzer.backend.exception.ResourceNotFoundException;
import com.vnalyzer.backend.model.User;
import com.vnalyzer.backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo){
        this.repo=repo;
    }

    public User createUser(User user){
        return repo.save(user);
    }

    public List<User> getAllUser(){
        return repo.findAll();
    }

    public User getUserById(Long id){
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));
    }

    public User updateById(Long id,User userdetails){
        User ex = getUserById(id);
        ex.setEmail(userdetails.getEmail());
        ex.setName(userdetails.getName());
        ex.setPassword(userdetails.getPassword());
        return repo.save(ex);
    }
    public void deleteUserById(Long id){
        getUserById(id);
        repo.deleteById(id);
    }

    
}
