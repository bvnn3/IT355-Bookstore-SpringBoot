package com.bookstore.IT355_Project.controller;

import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAll(){
        return ResponseEntity.ok(cartService.findAll());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getById(@PathVariable Integer cartId){
        return ResponseEntity.ok(cartService.findById(cartId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartNotFound")));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<Cart> findByUser_Id(@PathVariable Integer userId){
        return ResponseEntity.ok(cartService.findByUser_Id(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartNotFound")));
    }

    @PostMapping("/addCart")
    public ResponseEntity<Cart> save(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.save(cart));
    }

    @PutMapping("/updateCart")
    public ResponseEntity<Cart> update(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.update(cart));
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Cart> deleteById(@PathVariable Integer cartId){
        cartService.deleteById(cartId);
        return ResponseEntity.ok().build();
    }
}
