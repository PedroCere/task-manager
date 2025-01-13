package com.example.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    @Pattern(
            regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$",
            message = "Insert a valid email"
    )
    @Email(message = "Email must have ´@´")
    @NotNull(message = "Email cannot be empty")
    private String email;


    @NotNull(message = "Username cannot be empty")
    private String username;
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = """
                        The password must be at least 8 characters long,
                        contain at least one digit, one lowercase letter, one uppercase letter, one special character (@#$%^&+=) and no spaces,
                        a special character (@#$%^&&+=) and must not contain spaces."""
    )
    @NotNull(message = "Password must not be empty")
    private String password;




}
