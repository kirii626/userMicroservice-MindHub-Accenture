package com.mindhub.user_microservice.services.mappers;

import com.mindhub.user_microservice.dtos.UserDtoInput;
import com.mindhub.user_microservice.dtos.UserDtoOutput;
import com.mindhub.user_microservice.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDtoOutput toDto(UserEntity userEntity) {
        return new UserDtoOutput(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getRoleType()
        );
    }

    public List<UserDtoOutput> toDtoList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDtoInput userDtoInput) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDtoInput.getUsername());
        userEntity.setEmail(userDtoInput.getEmail());
        userEntity.setPassword(userDtoInput.getPassword());
        return userEntity;
    }
}
