package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> findAll();
    Optional<Publisher> findById(Integer publisherId);
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
    void deleteById(Integer publisherId);
}
