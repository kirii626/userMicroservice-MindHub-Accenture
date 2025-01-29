package com.mindhub.user_microservice.services.validations;

import com.mindhub.user_microservice.exceptions.UserAlreadyExistsExc;
import com.mindhub.user_microservice.exceptions.UserNotFoundExc;
import com.mindhub.user_microservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidUserFields {

    @Autowired
    private UserRepository userRepository;

    public void validateEmailUniqueness(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be null or empty.");
        }

        boolean emailExists = userRepository.findByEmail(email).isPresent();
        if (emailExists) {
            throw new UserAlreadyExistsExc("A user with the provided email already exists.");
        }
    }

    public void validateUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID: " + userId);
        }

        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new UserNotFoundExc("User with ID " + userId + " not found");
        }
    }

}
