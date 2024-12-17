package com.example.user_service.servicies;

import com.example.user_service.exception.UserAlreadyExistsException;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.encoder = passwordEncoder;
    }
    @Override
    public User create(User user) {

        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("A user with this email already Exists" + user.getEmail());
        }

        User newUser = User.builder()
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .email(user.getEmail())
                .build();

        return userRepository.save(newUser);
    }


}


