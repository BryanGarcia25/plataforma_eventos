package com.example.microservice_users.microservice_users.dto;

import java.util.Date;

/**
 * UserDto
 */
public record UserDto(Long id, String name, String lastname, String email, String telephone, String password, String role, Date createdAt) {

}