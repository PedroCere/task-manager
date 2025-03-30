package com.example.auth_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;


}
