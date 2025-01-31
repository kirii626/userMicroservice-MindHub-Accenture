package com.mindhub.user_microservice.controllers;

import com.mindhub.user_microservice.dtos.LoginUser;
import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.services.AuthService;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserDtoOutput>> registerUser(@Valid @RequestBody UserDtoInput userDtoInput) {
        return authService.createUser(userDtoInput);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginUser loginUser) {
        String jwt = authService.authenticateAndGenerateToken(
                loginUser.getEmail(),
                loginUser.getPassword());
        return ResponseEntity.ok(jwt);
    }
}
