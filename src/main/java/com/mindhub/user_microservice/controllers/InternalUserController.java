package com.mindhub.user_microservice.controllers;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal/user")
public class InternalUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/by-email")
    public ResponseEntity<Long> getUserIdByEmail(@RequestParam String email) {
        Long userId = userService.findUserIdByEmail(email);
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/{userId}/email")
    public ResponseEntity<String> getUserEmail(@PathVariable Long userId) {
        return userService.findEmailByUserId(userId);
    }
}
