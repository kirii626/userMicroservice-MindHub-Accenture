package com.mindhub.user_microservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDtoInput {

    @NotBlank(message = "The username can't be null")
    private String username;

    @NotBlank(message = "The email can't be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "The password can't be null")
    private String password;

    public UserDtoInput() {
    }

    public UserDtoInput(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
