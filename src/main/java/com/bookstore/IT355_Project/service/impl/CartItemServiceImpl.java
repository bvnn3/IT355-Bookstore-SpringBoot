package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Book;
import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.entity.CartItem;
import com.bookstore.IT355_Project.repository.CartItemRepository;
import com.bookstore.IT355_Project.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public Optional<CartItem> findById(Integer cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteById(Integer cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public List<CartItem> findByCart_User_Id(Integer userId) {
        return cartItemRepository.findByCart_User_Id(userId);
    }

    @Override
    public void deleteByCart_User_Id(Integer userId) {
        cartItemRepository.deleteByCart_User_Id(userId);
    }


}
