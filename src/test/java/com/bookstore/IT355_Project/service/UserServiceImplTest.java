package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.User;
import com.bookstore.IT355_Project.repository.UserRepository;
import com.bookstore.IT355_Project.service.impl.UserServiceImpl;
import com.bookstore.IT355_Project.tool.JwtTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();

        assertEquals(users, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        Optional<User> result = userService.findById(id);

        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        assertEquals(user, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.update(user);

        assertEquals(user, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(userRepository).deleteById(id);

        userService.deleteById(id);

        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(userRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> userService.deleteById(id));
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    public void testLoginSuccess() {
        String email = "test@example.com";
        String password = "password";
        User user = new User();
        user.setEmail(email);

        when(userRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.of(user));
        String token = "fake-jwt-token";
        mockStatic(JwtTool.class);
        when(JwtTool.generateToken(email)).thenReturn(token);

        ResponseEntity<?> response = userService.login(email, password);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
        assertEquals(user, responseBody.get("user"));
        assertEquals(token, responseBody.get("jwt"));

        verify(userRepository, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testLoginFailure() {
        String email = "test@example.com";
        String password = "password";

        when(userRepository.findByEmailAndPassword(email, password)).thenReturn(Optional.empty());

        ResponseEntity<?> response = userService.login(email, password);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Login failed", response.getBody());

        verify(userRepository, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testLoginException() {
        String email = "test@example.com";
        String password = "password";

        when(userRepository.findByEmailAndPassword(email, password)).thenThrow(RuntimeException.class);

        ResponseEntity<?> response = userService.login(email, password);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        verify(userRepository, times(1)).findByEmailAndPassword(email, password);
    }

    @Test
    public void testEmailExists() {
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(new User()));

        boolean exists = userService.emailExists(email);

        assertTrue(exists);
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    public void testEmailNotExists() {
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        boolean exists = userService.emailExists(email);

        assertFalse(exists);
        verify(userRepository, times(1)).findByEmail(email);
    }
}