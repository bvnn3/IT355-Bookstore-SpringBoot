package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> findAll();
    Optional<Cart> findById(Integer cartId);
    Cart save(Cart cart);
    Cart update(Cart cart);
    void deleteById(Integer cartId);
    Optional<Cart> findByUser_Id(Integer userId);

}
