package com.mindhub.user_microservice.dtos;

import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.models.enums.RolType;

public class UserDtoOutput {

    private String username;

    private String email;

    private RolType rolType;

    public UserDtoOutput(UserEntity userEntity) {
        username = userEntity.getUsername();
        email = userEntity.getEmail();
        rolType = userEntity.getRolType();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RolType getRolType() {
        return rolType;
    }
}
