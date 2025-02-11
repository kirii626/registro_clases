package com.example.registro_clase.exceptions;

public class UserAlreadyExistsExc extends RuntimeException {
    public UserAlreadyExistsExc(String message) {
        super(message);
    }
}
