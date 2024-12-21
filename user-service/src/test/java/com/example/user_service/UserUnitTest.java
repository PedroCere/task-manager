package com.example.user_service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.servicies.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserUnitTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testThatCreateSuccess(){

        //Arrange
        User user = new User(null,"user","user@gmail.com","password", null,null);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        //Act
        User createdUser = userService.create(user);

        //Assert
        verify(userRepository,times(1)).existsByEmail(user.getEmail());
        verify(userRepository,times(1)).save(user);

        assertNotNull(createdUser);

    }

    @Test
    public void testThatGetUserByEmailSuccess(){

        //Arrange
        User user = new User(null,"user","user@gmail.com","password",null,null);
        String email = user.getEmail();
        when(!userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        //Act
        User foundUser = userService.getUserByEmail(user.getEmail());

        //Assert
        verify(userRepository,times(1)).findByEmail(user.getEmail());
        assertEquals(email, foundUser.getEmail());
    }




}
