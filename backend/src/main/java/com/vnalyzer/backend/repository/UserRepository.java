package com.vnalyzer.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vnalyzer.backend.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

    boolean existsByEmail(String email);
    
}
