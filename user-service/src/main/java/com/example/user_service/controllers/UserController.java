package com.example.user_service.controllers;

import com.example.user_service.dto.UserDto;
import com.example.user_service.mappers.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.servicies.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping("/create")
    private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User savedUser = userService.create(user);
        UserDto savedUserDto = userMapper.toDto(user);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }




}
