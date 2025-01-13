package com.example.task_service.feign;

import com.example.task_service.dto.ProjectDto;
import com.example.task_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service",url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable Long userId);


}