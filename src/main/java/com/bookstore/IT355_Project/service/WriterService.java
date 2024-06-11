package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Writer;

import java.util.List;
import java.util.Optional;

public interface WriterService {
    List<Writer> findAll();
    Optional<Writer> findById(Integer writerId);
    Writer save(Writer writer);
    Writer update(Writer writer);
    void deleteById(Integer writerId);
}
