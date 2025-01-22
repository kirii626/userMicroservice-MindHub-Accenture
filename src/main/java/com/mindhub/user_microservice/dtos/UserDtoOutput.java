package com.mindhub.user_microservice.dtos;

import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.models.enums.RoleType;

public class UserDtoOutput {

    private Long id;

    private String username;

    private String email;

    private RoleType roleType;

    public UserDtoOutput(Long id, String username, String email, RoleType roleType) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleType = roleType;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public RoleType getRoleType() {
        return roleType;
    }
}
