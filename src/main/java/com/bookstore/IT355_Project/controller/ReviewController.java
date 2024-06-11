package com.bookstore.IT355_Project.controller;

import com.bookstore.IT355_Project.entity.Review;
import com.bookstore.IT355_Project.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> getAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getById(@PathVariable Integer reviewId){
        return ResponseEntity.ok(reviewService.findById(reviewId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "reviewNotFound")));
    }

    @PostMapping("/addReview")
    public ResponseEntity<Review> save(@RequestBody Review review){
        return ResponseEntity.ok(reviewService.save(review));
    }

    @PutMapping("/updateReview")
    public ResponseEntity<Review> update(@RequestBody Review review){
        return ResponseEntity.ok(reviewService.update(review));
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Review> deleteById(@PathVariable Integer reviewId){
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getByBookId/{bookId}")
    public ResponseEntity<List<Review>> getByBookId(@PathVariable Integer bookId){
        return  ResponseEntity.ok(reviewService.findByBookId(bookId));
    }
}
