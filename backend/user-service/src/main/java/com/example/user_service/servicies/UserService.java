package com.example.user_service.servicies;

import com.example.user_service.config.ExtendedBaseResponse;
import com.example.user_service.dto.UserDto;
import com.example.user_service.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User create(User user);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    void deleteUser(User userToDelete);

    User fullUpdate(User user);
}
