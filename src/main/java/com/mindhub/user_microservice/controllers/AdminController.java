package com.mindhub.user_microservice.controllers;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDtoOutput>> getAllUsers(HttpServletRequest request) {
        String role = request.getHeader("X-Role");
        return ResponseEntity.ok(userService.getAllUsers(role));
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
