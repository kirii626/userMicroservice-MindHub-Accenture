package com.mindhub.user_microservice.services;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDtoOutput> findAllUsers();

    ResponseEntity<ApiResponse<UserDtoOutput>> createUser(UserDtoInput userDtoInput);

    ResponseEntity<ApiResponse<UserDtoOutput>> updateUser(Long userId, UserDtoInput userDtoInput);

    Long findUserIdByEmail(String email);
}
