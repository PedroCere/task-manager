package com.example.auth_service.services;

import com.example.auth_service.config.UserClient;
import com.example.auth_service.config.JwtUtil;
import com.example.auth_service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl  {

    private final UserClient userClient;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterRequest request) {
        UserRequestDto userRequest = new UserRequestDto(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );
        userClient.createUser(userRequest);
    }


    public String loginUser(LoginRequest loginRequest) {
        UserResponseDto userResponse = userClient.getUserByEmail(loginRequest.getEmail());

        if (userResponse == null || !passwordEncoder.matches(loginRequest.getPassword(), userResponse.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        return jwtUtil.generateToken(userResponse.getEmail());
    }
}
