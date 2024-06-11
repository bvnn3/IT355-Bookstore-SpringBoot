package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Book;
import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.entity.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query("select c from CartItem c where c.cart.user.id = ?1")
    List<CartItem> findByCart_User_Id(Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem ci WHERE ci.cart.id IN (SELECT c.id FROM Cart c WHERE c.user.id = ?1)")
    void deleteByCart_User_Id(Integer userId);
}