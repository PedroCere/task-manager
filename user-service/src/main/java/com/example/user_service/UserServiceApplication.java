package com.example.user_service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Base64;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	public static void main(String[] args) {
		byte[] key = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
		String base64Key = Base64.getEncoder().encodeToString(key);
		System.out.println("Generated JWT Secret Key: " + base64Key);
		SpringApplication.run(UserServiceApplication.class, args);

	}
}



