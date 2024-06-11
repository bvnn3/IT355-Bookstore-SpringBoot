package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}