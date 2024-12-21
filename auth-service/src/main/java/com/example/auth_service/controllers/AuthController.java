package com.example.auth_service.controllers;

import com.example.auth_service.config.TokenProvider;
import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.LoginResponse;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.ValidateTokenResponse;
import com.example.auth_service.response.BaseResponse;
import com.example.auth_service.services.AuthService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private TokenProvider tokenProvider;

    public AuthController(AuthService authService, TokenProvider tokenProvider) {
        this.authService = authService;
        this.tokenProvider = tokenProvider;
    }


    @PostMapping("/register")
    public ResponseEntity<BaseResponse> registerUser(@Valid @RequestBody RegisterRequest request){

        authService.registerUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(BaseResponse.created("User Registered succesfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        authService.test();
        String token = authService.loginUser(loginRequest);
        return ResponseEntity.ok(new LoginResponse("Login successful", token));
    }

    @GetMapping("/validate")
    public ResponseEntity<ValidateTokenResponse> validateToken(@RequestParam String token) {
        Claims claims = tokenProvider.validateToken(token);
        return ResponseEntity.ok(new ValidateTokenResponse(claims.getSubject(), (String) claims.get("roles")));
    }


}
