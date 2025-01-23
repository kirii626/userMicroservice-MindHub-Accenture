package com.mindhub.user_microservice.repositories;

import com.mindhub.user_microservice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u.id FROM UserEntity u WHERE u.email = :email")
    Optional<Long> findUserIdByEmail(@Param("email") String email);

    Optional<UserEntity> findByEmail(String email);

}
