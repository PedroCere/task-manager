package com.example.user_service.servicies;


import com.example.user_service.exception.UserAlreadyExistsException;
import com.example.user_service.mappers.UserMapper;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
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
    @Autowired
    private KafkaTemplate<String, Long> kafkaTemplate;

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

    @Override
    public void deleteUser(User userToDelete) {
        if (userToDelete == null || !userRepository.existsByEmail(userToDelete.getEmail())) {
            System.out.println("User with email " + (userToDelete != null ? userToDelete.getEmail() : "null") + " not found.");
            throw new IllegalArgumentException("User not found");
        }

        // Eliminar el usuario
        userRepository.delete(userToDelete);
        System.out.println("User deleted successfully: " + userToDelete.getEmail());

        // Enviar evento a Kafka con manejo de excepciones
        try {
            System.out.println("Sending event to Kafka: user-deleted-topic, userId=" + userToDelete.getId());
            kafkaTemplate.send("user-deleted-topic", userToDelete.getId()); // Envía el ID como Long
            System.out.println("Event published to Kafka for user ID: " + userToDelete.getId());
        } catch (Exception e) {
            System.err.println("Failed to publish Kafka event: " + e.getMessage());
        }
    }

}


