package com.example.microservice_users.microservice_users.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.microservice_users.microservice_users.dto.UserDto;

@Service
public interface UserService {
    
    String saveUser(UserDto userDto);
    List<UserDto> findAllUsers();
    UserDto findUserById(int id);
    String updateUser(Integer id, UserDto userDto);
    String deleteUser(Integer id);

}
