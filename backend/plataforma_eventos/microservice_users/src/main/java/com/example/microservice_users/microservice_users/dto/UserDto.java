package com.example.microservice_users.microservice_users.dto;

import java.time.LocalDateTime;

/**
 * UserDto
 */
public record UserDto(Long id, String name, String lastname, String email, String telephone, String password, String role, LocalDateTime createdAt) {

}