package com.example.user_service.config;

import com.example.user_service.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service",url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/users/{email}")
    UserResponseDto getUserByEmail(@PathVariable("email")String email);
}
