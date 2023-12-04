package com.example.boking.exception;

public class HotelException extends RuntimeException{
    public HotelException(String message, Exception ex) {
        super(message, ex);
    }

}
