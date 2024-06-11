package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Integer userId);
    User save(User user);
    User update(User user);
    void deleteById(Integer userId);
    ResponseEntity<?> login(String email, String password);
    boolean emailExists(String email);
}
