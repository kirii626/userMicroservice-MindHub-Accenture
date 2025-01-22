package com.mindhub.user_microservice.controllers;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDtoOutput> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserDtoOutput>> createUser(@Valid @RequestBody UserDtoInput userDtoInput) {
        return userService.createUser(userDtoInput);
    }

    @PutMapping("/{userId}")
    private ResponseEntity<ApiResponse<UserDtoOutput>> updateUser(@Valid @PathVariable Long userId,
                                                                  @RequestBody UserDtoInput userDtoInput) {
        return userService.updateUser(userId, userDtoInput);
    }
}
