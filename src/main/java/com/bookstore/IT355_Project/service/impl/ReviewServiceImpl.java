package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Review;
import com.bookstore.IT355_Project.repository.ReviewRepository;
import com.bookstore.IT355_Project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(Integer reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> findByBookId(Integer bookId) {
        return reviewRepository.findByBook_Id(bookId);
    }
}
