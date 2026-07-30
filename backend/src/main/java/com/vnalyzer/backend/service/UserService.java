package com.vnalyzer.backend.service;

import org.springframework.stereotype.Service;

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

    
}
