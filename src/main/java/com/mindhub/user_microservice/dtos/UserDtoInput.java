package com.mindhub.user_microservice.dtos;

import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.models.enums.RolType;

public class UserDtoInput {

    private Long id;

    private String username;

    private String email;

    private RolType rolType;

    public UserDtoInput() {
    }

    public UserDtoInput(String username, String email, RolType rolType) {
        this.username = username;
        this.email = email;
        this.rolType = rolType;
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
