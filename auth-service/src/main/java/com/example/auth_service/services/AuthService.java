package com.example.auth_service.services;

import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;

public interface AuthService {


    void registerUser(RegisterRequest request);

    String loginUser(LoginRequest loginRequest);

    void test();
}
