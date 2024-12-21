package com.example.user_service.controllers;

import com.example.user_service.config.BaseResponse;
import com.example.user_service.config.ExtendedBaseResponse;
import com.example.user_service.dto.UserDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.mappers.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.servicies.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping("/create")
    private ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto dto){
        User user = userMapper.toEntity(dto);
        User savedUser = userService.create(user);
        UserDto savedUserDto = userMapper.toDto(savedUser);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<ExtendedBaseResponse<List<UserDto>>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        List<UserDto> allUsersDto = userMapper.toListOfDto(allUsers);

        return new ResponseEntity<>(
                ExtendedBaseResponse.of(BaseResponse.ok("Fetched all users successfully"), allUsersDto),
                HttpStatus.OK
        );
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable String email) {
        Optional<User> user = Optional.ofNullable(userService.getUserByEmail(email));
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Convertir la entidad User a DTO
        UserResponseDto userResponse = UserResponseDto.builder()
                .username(user.get().getUsername())
                .email(user.get().getEmail())
                .password(user.get().getPassword())
                .build();
        System.out.println(passwordEncoder.matches("_Ananashe10", "$2a$10$CJfKRnazjhC8NwwJM6QZdut/0APjYNhTQSMIE9Lks9/Wo2KuixocK"));
        return ResponseEntity.ok(userResponse);
    }



}
