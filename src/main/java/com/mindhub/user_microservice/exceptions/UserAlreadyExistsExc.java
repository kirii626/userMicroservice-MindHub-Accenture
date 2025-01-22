package com.mindhub.user_microservice.exceptions;

public class UserAlreadyExistsExc extends RuntimeException {
    public UserAlreadyExistsExc(String message) {
        super(message);
    }
}
