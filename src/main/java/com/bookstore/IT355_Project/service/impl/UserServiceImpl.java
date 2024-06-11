package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.User;
import com.bookstore.IT355_Project.repository.UserRepository;
import com.bookstore.IT355_Project.service.UserService;
import com.bookstore.IT355_Project.tool.JwtTool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public ResponseEntity<?> login(String email, String password) {
        try {
            Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
            if (optionalUser.isEmpty()) {
                return new ResponseEntity<>("Login failed", HttpStatus.BAD_REQUEST);
            }
            User user = optionalUser.get();
            String jwt = JwtTool.generateToken(user.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("jwt", jwt);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
