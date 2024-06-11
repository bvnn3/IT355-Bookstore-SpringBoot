package com.bookstore.IT355_Project.repository;

import com.bookstore.IT355_Project.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}