package com.example.user_service.controllers;

import com.example.user_service.dto.UserDto;
import com.example.user_service.mappers.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.servicies.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping
    private ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> allUsersDto = userMapper.toListOfDto(allUsers);
        return new ResponseEntity<>(allUsersDto, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    private ResponseEntity<Optional<UserDto>> getUserByEmail(@PathVariable("email")String email){
    Optional<User> newUser = userService.getUserByEmail(email);
    Optional<UserDto> userDto = newUser.map(user -> userMapper.toDto(user));
    return new ResponseEntity<>(userDto,HttpStatus.OK);
    }




}
