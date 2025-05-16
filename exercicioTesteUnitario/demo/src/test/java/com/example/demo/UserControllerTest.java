package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.controller.UserController;
import com.example.model.User;
import com.example.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    void testGetUserById() {
        User user = new User("1L", "João", "joao@email.com");

        Mockito.when(userService.getUserById("1L")).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById("1L");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("João", response.getBody().getNome());
    }

    @Test
    void testCreateUser() {
        User user = new User(null, "Maria", "maria@email.com");
        User savedUser = new User("2L", "Maria", "maria@email.com");

        Mockito.when(userService.createUser(user)).thenReturn(savedUser);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2L, response.getBody().getId());
    }
}
