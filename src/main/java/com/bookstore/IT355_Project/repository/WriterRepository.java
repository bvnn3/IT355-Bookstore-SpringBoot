package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Integer> {
}