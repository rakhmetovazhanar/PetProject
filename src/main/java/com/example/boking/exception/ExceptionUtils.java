package com.example.boking.exception;

import jakarta.security.auth.message.AuthException;
import org.springframework.http.HttpStatus;

public class ExceptionUtils extends RuntimeException{
    public AuthException notFound(String message) {
        return new AuthException(message, HttpStatus.NOT_FOUND);
    }
}
