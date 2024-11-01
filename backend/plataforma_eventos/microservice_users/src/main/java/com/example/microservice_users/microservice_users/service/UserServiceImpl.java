package com.example.microservice_users.microservice_users.service;

import java.util.List;
import java.util.Optional;

import com.example.microservice_users.microservice_users.constants.Messages;
import com.example.microservice_users.microservice_users.dto.UserDto;
import com.example.microservice_users.microservice_users.entities.User;
import com.example.microservice_users.microservice_users.repository.UserRepository;

import jakarta.ws.rs.NotFoundException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String saveUser(UserDto userDto) {
        User user = new User(null, userDto.name(), userDto.lastname(), userDto.email(), userDto.telephone(), userDto.password(), userDto.role(), userDto.createdAt());

        userRepository.save(user);

        return Messages.USER_CREATED;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDto(user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getTelephone(), user.getPassword(), user.getRole(), user.getCreatedAt())).toList();
    }

    @Override
    public UserDto findUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.USER_NOTFOUND));

        return new UserDto(user.getId(), user.getName(), user.getLastname(), user.getEmail(), user.getTelephone(), user.getPassword(), user.getRole(), user.getCreatedAt());
    }

    @Override
    public String updateUser(Integer id, UserDto userDto) {
        User userFound = userRepository.findById(id).orElseThrow(() -> new NotFoundException(Messages.USER_NOTFOUND));

        userFound.setName(userDto.name());
        userFound.setLastname(userDto.lastname());
        userFound.setEmail(userDto.email());
        userFound.setTelephone(userDto.telephone());
        userFound.setPassword(userDto.password());
        userFound.setRole(userDto.role());

        userRepository.save(userFound);

        return Messages.USER_UPDATED;
    }

    @Override
    public String deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            return Messages.USER_NOTFOUND;
        }

        userRepository.deleteById(id);

        return Messages.USER_DELETED;
    }
}
