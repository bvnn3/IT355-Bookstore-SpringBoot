package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);
}