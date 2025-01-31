package com.mindhub.user_microservice.controllers;

import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDtoOutput> getUserProfile(HttpServletRequest request) {
        String username = request.getHeader("X-Username");
        return ResponseEntity.ok(userService.getUserProfile(username));
    }

}
