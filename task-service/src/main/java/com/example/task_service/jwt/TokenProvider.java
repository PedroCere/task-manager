package com.example.task_service.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

public class TokenProvider {

    private final SecretKey secretKey;
    private final long expiration;

    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.expiration}") long expiration) {
        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret)); // Decodifica la clave Base64
        this.expiration = expiration;
    }
/*
    public String generateToken(TokenResponseDto user) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey, SignatureAlgorithm.HS512) // Usa la clave decodificada
                .compact();
    }

 */

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey) // Usa la misma clave decodificada
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
