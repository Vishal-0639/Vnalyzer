package com.vnalyzer.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
//import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

// @Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(name="email",nullable=false,unique=true)
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be in valid format")
    private String email;

    @Column(nullable=false)
    @NotBlank(message = "Password cannot be empty")
    @Size(min=8,message="Password should be at least 8 characters long")
    private String password;

    @CreationTimestamp
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    public String getName() {
    return name;
}
public void setId(Long id) {
    this.id = id;
}
public Long getId() {
    return id;
}
public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

}