package com.example.auth_service.config;

import io.jsonwebtoken.security.Keys;

import java.util.Base64;

public class SecretGenerator {
    public static void main(String[] args) {
        byte[] key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated JWT Secret: " + base64Key);
    }
}


