package com.bookstore.IT355_Project.controller;

import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.entity.User;
import com.bookstore.IT355_Project.service.CartService;
import com.bookstore.IT355_Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CartService cartService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "userNotFound")));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> save(@RequestBody User user){
//        return ResponseEntity.ok(userService.save(user));
        User savedUser = userService.save(user);


        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartService.save(cart);

        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        return userService.login(user.getEmail(), user.getPassword());
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable Integer userId){
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/checkEmailExists")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = userService.emailExists(email);
        return ResponseEntity.ok(exists);
    }
}
