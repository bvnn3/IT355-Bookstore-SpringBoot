package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Book;
import com.bookstore.IT355_Project.repository.BookRepository;
import com.bookstore.IT355_Project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
