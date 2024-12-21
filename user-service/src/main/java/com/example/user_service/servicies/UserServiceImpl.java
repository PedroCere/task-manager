package com.example.user_service.servicies;


import com.example.user_service.exception.UserAlreadyExistsException;
import com.example.user_service.mappers.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    public User create(User user) {
        // Verificar si el usuario ya existe
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("A user with this email already exists: " + user.getEmail());
        }

        User newUser = User.builder()
                .username(user.getUsername())
                .password((user.getPassword()))
                .email(user.getEmail())
                .build();

        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        System.out.println("Buscando usuario con email: " + email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            System.out.println("Usuario no encontrado: " + email);
        } else {
            System.out.println("Usuario encontrado: " + user.getEmail());
        }
        return user;
    }
}


