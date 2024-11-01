package com.example.microservice_users.microservice_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservice_users.microservice_users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
