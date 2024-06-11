package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Integer bookId);
    Book save(Book book);
    Book update(Book book);
    void deleteById(Integer bookId);
}
