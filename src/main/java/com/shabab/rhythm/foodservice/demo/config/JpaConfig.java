package com.shabab.rhythm.foodservice.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.shabab.rhythm.foodservice.demo.repositories")
public class JpaConfig {
}
