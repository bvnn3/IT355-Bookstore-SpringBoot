package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Optional<Review> findById(Integer reviewId);
    Review save(Review review);
    Review update(Review review);
    void deleteById(Integer reviewId);
    List<Review> findByBookId(Integer bookId);
}
