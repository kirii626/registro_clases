package com.example.registro_clase.exceptions;

public class UserNotFoundExc extends RuntimeException {
    public UserNotFoundExc(String message) {
        super(message);
    }
}
