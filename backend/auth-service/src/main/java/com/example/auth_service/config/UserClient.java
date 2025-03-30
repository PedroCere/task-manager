package com.example.auth_service.config;

import com.example.auth_service.dto.UserRequestDto;
import com.example.auth_service.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/users/{email}")
    UserResponseDto getUserByEmail(@PathVariable("email") String email);

    @PostMapping("/users/create")
    UserResponseDto createUser(@RequestBody UserRequestDto dto);
}
