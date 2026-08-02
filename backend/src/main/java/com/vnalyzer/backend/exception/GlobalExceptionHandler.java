package com.vnalyzer.backend.exception;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourcenotfound(ResourceNotFoundException ex){
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());

    } 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodnotfound(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(),error.getDefaultMessage());
        }
        return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(errors);

    }
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<String> druplicateEntity(DuplicateResourceException ex){
        return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(ex.getMessage());

    }
    
    
}
