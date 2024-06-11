package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.repository.CartRepository;
import com.bookstore.IT355_Project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Integer cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public Optional<Cart> findByUser_Id(Integer userId) {
        return cartRepository.findByUser_Id(userId);
    }


}
