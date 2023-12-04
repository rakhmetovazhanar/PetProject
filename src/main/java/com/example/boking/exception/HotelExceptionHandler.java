package com.example.boking.exception;

import com.example.boking.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HotelExceptionHandler {
    @ExceptionHandler(HotelException.class)
    public ResponseEntity<?> hotelHandler(HotelException ex){
        return ResponseEntity.badRequest().build();
    }
}
