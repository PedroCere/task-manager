package com.example.user_service.servicies;

import com.example.user_service.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User create(User user);

    List<User> getAllUsers();

    Optional<User> getUserByEmail(String email);
}
