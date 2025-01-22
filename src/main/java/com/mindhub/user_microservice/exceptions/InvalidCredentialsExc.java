package com.mindhub.user_microservice.exceptions;

public class InvalidCredentialsExc extends RuntimeException {
    public InvalidCredentialsExc(String message) {
        super(message);
    }
}
