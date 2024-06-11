package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Review;
import com.bookstore.IT355_Project.repository.ReviewRepository;
import com.bookstore.IT355_Project.service.impl.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ReviewServiceImplTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Review> reviews = Arrays.asList(new Review(), new Review());
        when(reviewRepository.findAll()).thenReturn(reviews);

        List<Review> result = reviewService.findAll();

        assertEquals(reviews, result);
        verify(reviewRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Review review = new Review();
        when(reviewRepository.findById(id)).thenReturn(Optional.of(review));

        Optional<Review> result = reviewService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(review, result.get());
        verify(reviewRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(reviewRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Review> result = reviewService.findById(id);

        assertFalse(result.isPresent());
        verify(reviewRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Review review = new Review();
        when(reviewRepository.save(review)).thenReturn(review);

        Review result = reviewService.save(review);

        assertEquals(review, result);
        verify(reviewRepository, times(1)).save(review);
    }

    @Test
    public void testUpdate() {
        Review review = new Review();
        when(reviewRepository.save(review)).thenReturn(review);

        Review result = reviewService.update(review);

        assertEquals(review, result);
        verify(reviewRepository, times(1)).save(review);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(reviewRepository).deleteById(id);

        reviewService.deleteById(id);

        verify(reviewRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(reviewRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> reviewService.deleteById(id));
        verify(reviewRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByBookId() {
        int bookId = 1;
        List<Review> reviews = Arrays.asList(new Review(), new Review());
        when(reviewRepository.findByBook_Id(bookId)).thenReturn(reviews);

        List<Review> result = reviewService.findByBookId(bookId);

        assertEquals(reviews, result);
        verify(reviewRepository, times(1)).findByBook_Id(bookId);
    }

    @Test
    public void testFindByBookIdNotFound() {
        int bookId = 1;
        when(reviewRepository.findByBook_Id(bookId)).thenReturn(Arrays.asList());

        List<Review> result = reviewService.findByBookId(bookId);

        assertTrue(result.isEmpty());
        verify(reviewRepository, times(1)).findByBook_Id(bookId);
    }
}
