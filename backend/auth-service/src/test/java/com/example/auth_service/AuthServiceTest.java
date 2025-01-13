package com.example.auth_service;

import com.example.auth_service.config.TokenProvider;
import com.example.auth_service.config.UserClient;
import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserRequestDto;
import com.example.auth_service.dto.UserResponseDto;
import com.example.auth_service.services.AuthServiceImpl;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class AuthServiceTest {

    @Mock
    private UserClient userClient;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private TokenProvider tokenProvider;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_success(){

        //Arrange
        RegisterRequest request = new RegisterRequest("user@gmail.com", "user", "password");
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encryptedPassword");

        //Act
        authService.registerUser(request);

        //Assert
        verify(userClient,times(1)).createUser(any(UserRequestDto.class));
        verify(passwordEncoder,times(1)).encode(request.getPassword());

    }

    @Test
    void loginUser_success(){

        //Arrange
        LoginRequest loginRequest = new LoginRequest("user@gmail.com", "password");
        UserResponseDto userResponse = new UserResponseDto("user@gmail.com", "encryptedPassword");

        when(userClient.getUserByEmail(loginRequest.getEmail())).thenReturn(userResponse);
        when(passwordEncoder.matches(loginRequest.getPassword(), userResponse.getPassword())).thenReturn(true);
        when(tokenProvider.generateToken(userResponse)).thenReturn("jwtToken");


        //Acto
        String token = authService.loginUser(loginRequest);


        //Assert
        verify(userClient,times(1)).getUserByEmail(loginRequest.getEmail());
        verify(passwordEncoder,times(1)).matches(loginRequest.getPassword(),userResponse.getPassword());
        verify(tokenProvider,times(1)).generateToken(userResponse);

        assertEquals("jwtToken", token);
    }

}
