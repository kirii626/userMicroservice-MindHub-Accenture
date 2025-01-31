package com.mindhub.user_microservice;

import com.mindhub.user_microservice.models.UserEntity;
import com.mindhub.user_microservice.models.enums.RoleType;
import com.mindhub.user_microservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(UserRepository userRepository) {

		return args -> {
			UserEntity userEntity = new UserEntity("tilino","testeando432@gmail.com", passwordEncoder.encode("1234"), RoleType.ADMIN);
			userRepository.save(userEntity);
		};
	}

}
