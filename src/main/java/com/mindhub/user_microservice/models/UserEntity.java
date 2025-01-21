package com.mindhub.user_microservice.models;

import com.mindhub.user_microservice.models.enums.RolType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private RolType rolType;

    public UserEntity() {
    }

    public UserEntity(String username, String email, String password, RolType rolType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolType = rolType;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolType getRolType() {
        return rolType;
    }

    public void setRolType(RolType rolType) {
        this.rolType = rolType;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rolType=" + rolType +
                '}';
    }
}
