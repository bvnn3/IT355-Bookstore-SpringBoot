package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {



    @Query("select c from Cart c where c.user.id = ?1")
    Optional<Cart> findByUser_Id(Integer id);

}