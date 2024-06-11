package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    List<CartItem> findAll();
    Optional<CartItem> findById(Integer cartItemId);
    CartItem save(CartItem cartItem);
    CartItem update(CartItem cartItem);
    void deleteById(Integer cartItemId);

    List<CartItem> findByCart_User_Id(Integer userId);
    void deleteByCart_User_Id(Integer userId);
}
