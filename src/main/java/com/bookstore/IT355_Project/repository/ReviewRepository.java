package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select r from Review r where r.book.id = ?1")
    List<Review> findByBook_Id(Integer id);

}