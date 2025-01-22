package com.mindhub.user_microservice.exceptions;

public class UserNotFoundExc extends RuntimeException {
  public UserNotFoundExc(String message) {
    super(message);
  }
}
