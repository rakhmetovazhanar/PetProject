package com.example.boking.exception;

public class RoomException extends RuntimeException{
    public RoomException(String message, Exception ex) {
        super(message, ex);
    }

}
