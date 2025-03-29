package com.example.auth_service.controllers;

import com.example.auth_service.dto.*;
import com.example.auth_service.response.BaseResponse;
import com.example.auth_service.services.AuthService;
import com.example.auth_service.config.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtUtil jwtUtil;

    @Autowired // Asegúrate de que Spring pueda inyectarlo
    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<BaseResponse> registerUser(@RequestBody RegisterRequest request) {
        authService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.created("User Registered successfully"));
    }

    @PostMapping("/login")
    @Operation(summary = "Login with existing user")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.loginUser(loginRequest);
        return ResponseEntity.ok(new LoginResponse("Login successful", token));
    }
}
