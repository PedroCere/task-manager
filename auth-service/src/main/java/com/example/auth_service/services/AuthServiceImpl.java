package com.example.auth_service.services;

import com.example.auth_service.config.TokenProvider;
import com.example.auth_service.config.UserClient;
import com.example.auth_service.dto.LoginRequest;
import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserRequestDto;
import com.example.auth_service.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserClient userClient;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterRequest request) {
        System.out.println("Registrando usuario: " + request.getEmail());
        System.out.println("Contraseña original: " + request.getPassword());

        UserRequestDto userRequest = UserRequestDto.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // Encripta la contraseña
                .build();

        // Llama al user-service para crear el usuario
        userClient.createUser(userRequest);
    }

    @Override
    public String loginUser (LoginRequest loginRequest) {
        System.out.println("Intentando iniciar sesión con email: " + loginRequest.getEmail());

        // Obtener información del usuario desde el user-service
        UserResponseDto userResponse = userClient.getUserByEmail(loginRequest.getEmail());

        if (userResponse == null) {
            throw new BadCredentialsException("Usuario no encontrado");
        }

        // Imprimir las contraseñas para depuración
        System.out.println("Contraseña ingresada: " + loginRequest.getPassword());
        System.out.println("Contraseña almacenada: " + userResponse.getPassword());

        // Verificar si la contraseña ingresada coincide con la encriptada
        boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), userResponse.getPassword());
        System.out.println("¿Coincide la contraseña? " + passwordMatches); // Esto debería ser true

        if (!passwordMatches) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        // Generar el token JWT
        return tokenProvider.generateToken(userResponse);
    }

    public void test() {
        String rawPassword = "caca"; // Contraseña original
        String encodedPassword = "$2a$10$zFyDFkfYH5/8k1dVqP0IaOtkSKCRPdLPNYll9VGS3Nbw2iWUiHQya"; // Contraseña encriptada correcta

        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("¿Coincide la contraseña? " + matches); // Esto debería ser true
    }
}
