package com.mindhub.user_microservice.services.implementations;

import com.mindhub.user_microservice.config.rabbit.JwtUtils;
import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.exceptions.InvalidCredentialsExc;
import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.services.AuthService;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<ApiResponse<UserDtoOutput>> createUser(UserDtoInput userDtoInput) {
        return userService.createUser(userDtoInput);
    }

    @Override
    public String authenticateAndGenerateToken(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String username = authentication.getName();

            String role = authentication.getAuthorities()
                    .stream()
                    .findFirst()
                    .map(authority -> authority.getAuthority())
                    .orElse("USER");

            Map<String, String> claims = new HashMap<>();
            claims.put("role", role);

            return jwtUtils.generateToken(username, claims);
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsExc("Invalid email or password");
        }
    }


}
