package com.lgrsdev.acsexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class AcsExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcsExerciseApplication.class, args);
	}

}
