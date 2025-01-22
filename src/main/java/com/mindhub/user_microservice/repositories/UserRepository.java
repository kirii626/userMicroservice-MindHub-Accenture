package com.mindhub.user_microservice.repositories;

import com.mindhub.user_microservice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
