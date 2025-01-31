package com.mindhub.user_microservice.services;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<ApiResponse<UserDtoOutput>> createUser(UserDtoInput userDtoInput);

    String authenticateAndGenerateToken(String email, String password);
}
