package com.bookstore.IT355_Project.controller;


import com.bookstore.IT355_Project.entity.CartItem;
import com.bookstore.IT355_Project.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/cartItem")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CartItem>> getAll(){
        return ResponseEntity.ok(cartItemService.findAll());
    }

    @GetMapping("/findByCart_User_Id/{userId}")
    public ResponseEntity<List<CartItem>> findByCart_User_Id(@PathVariable Integer userId){
        return ResponseEntity.ok(cartItemService.findByCart_User_Id(userId));
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItem> getById(@PathVariable Integer cartItemId){
        return ResponseEntity.ok(cartItemService.findById(cartItemId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cartItemNotFound")));
    }

    @PostMapping("/addCartItem")
    public ResponseEntity<CartItem> save(@RequestBody CartItem cartItem){
        return ResponseEntity.ok(cartItemService.save(cartItem));
    }

    @PutMapping("/updateCartItem")
    public ResponseEntity<CartItem> update(@RequestBody CartItem cartItem){
        return ResponseEntity.ok(cartItemService.update(cartItem));
    }
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<CartItem> deleteById(@PathVariable Integer cartItemId){
        cartItemService.deleteById(cartItemId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deleteByCart_User_Id/{userId}")
    public ResponseEntity<Void> deleteByCart_User_Id(@PathVariable Integer userId) {
        cartItemService.deleteByCart_User_Id(userId);
        return ResponseEntity.ok().build();
    }
}
