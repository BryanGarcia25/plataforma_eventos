package com.example.microservice_users.microservice_users.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice_users.microservice_users.dto.UserDto;
import com.example.microservice_users.microservice_users.service.UserServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/create_user")
    public String createUser(@RequestBody UserDto userDto) {
        return userServiceImpl.saveUser(userDto);
    }

    @GetMapping("/get_users")
    public List<UserDto> getAllUsers() {
        return userServiceImpl.findAllUsers();
    }

    @GetMapping("/get_user/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userServiceImpl.findUserById(id);
    }

    @PutMapping("/update_user/{id}")
    public String updateUserById(@PathVariable int id, @RequestBody UserDto userDto) {
        return userServiceImpl.updateUser(id, userDto);
    }

    @DeleteMapping("/delete_user/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userServiceImpl.deleteUser(id);
    }

}
