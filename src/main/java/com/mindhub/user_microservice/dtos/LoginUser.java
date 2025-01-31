package com.mindhub.user_microservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUser {

    @NotBlank(message = "The email can't be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "The password can't be null")
    private String password;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
