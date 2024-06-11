package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Book;
import com.bookstore.IT355_Project.repository.BookRepository;
import com.bookstore.IT355_Project.service.impl.BookServiceImpl;
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

public class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Book> books = Arrays.asList(new Book(), new Book());
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAll();

        assertEquals(books, result);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Book book = new Book();
        when(bookRepository.findById(id)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(book, result.get());
        verify(bookRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(bookRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Book> result = bookService.findById(id);

        assertFalse(result.isPresent());
        verify(bookRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.save(book);

        assertEquals(book, result);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.update(book);

        assertEquals(book, result);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(bookRepository).deleteById(id);

        bookService.deleteById(id);

        verify(bookRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(bookRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> bookService.deleteById(id));
        verify(bookRepository, times(1)).deleteById(id);
    }
}
