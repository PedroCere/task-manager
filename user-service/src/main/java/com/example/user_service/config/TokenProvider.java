package com.example.user_service.config;
import com.example.user_service.dto.UserResponseDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    private final SecretKey secretKey;
    private final long expirationTime;

    // Inyección de propiedades desde application.properties
    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.expiration}") long expirationTime) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes()); // Carga la clave
        this.expirationTime = expirationTime;
    }

    public String generateToken(UserResponseDto user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey, SignatureAlgorithm.HS512) // Usa la clave segura
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey) // Usa la clave segura
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
