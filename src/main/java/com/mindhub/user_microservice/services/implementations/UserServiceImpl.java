package com.mindhub.user_microservice.services.implementations;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.exceptions.UserNotFoundExc;
import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.repositories.UserRepository;
import com.mindhub.user_microservice.services.UserService;
import com.mindhub.user_microservice.services.mappers.UserMapper;
import com.mindhub.user_microservice.services.validations.ValidUserFields;
import com.mindhub.user_microservice.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ValidUserFields validUserFields;

    @Override
    public List<UserDtoOutput> findAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public ResponseEntity<ApiResponse<UserDtoOutput>> createUser(UserDtoInput userDtoInput) {
        validUserFields.validateEmailUniqueness(userDtoInput.getEmail());

        UserEntity userEntity = userMapper.toEntity(userDtoInput);
        UserEntity savedUser = userRepository.save(userEntity);
        UserDtoOutput userDtoOutput = userMapper.toDto(savedUser);
        ApiResponse<UserDtoOutput> response = new ApiResponse<>(
                "User created successfully",
                userDtoOutput
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<ApiResponse<UserDtoOutput>> updateUser(Long userId, UserDtoInput userDtoInput) {
        validUserFields.validateUserId(userId);

        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundExc("User not found by ID: " + userId));

        existingUser.setUsername(userDtoInput.getUsername());
        existingUser.setEmail(userDtoInput.getEmail());
        existingUser.setPassword(userDtoInput.getPassword());

        UserEntity updatedUser = userRepository.save(existingUser);

        UserDtoOutput userDtoOutput = userMapper.toDto(updatedUser);

        ApiResponse<UserDtoOutput> response = new ApiResponse<>(
                "User updated successfully",
                userDtoOutput
        );

        return ResponseEntity.ok(response);
    }

    @Override
    public Long findUserIdByEmail(String email) {
        return userRepository.findUserIdByEmail(email)
                .orElseThrow(() -> new UserNotFoundExc("User not found for email: " + email));
    }


}

