package com.example.user_service.config;

import org.hibernate.annotations.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderLogger {

    public PasswordEncoderLogger(ApplicationContext context) {
        String[] beans = context.getBeanNamesForType(PasswordEncoder.class);
        System.out.println("Beans PasswordEncoder registrados en el contexto:");
        for (String bean : beans) {
            System.out.println("- " + bean + " -> " + context.getBean(bean).getClass().getName());
        }
    }
}
