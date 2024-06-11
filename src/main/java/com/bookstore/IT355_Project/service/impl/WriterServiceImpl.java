package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Writer;
import com.bookstore.IT355_Project.repository.WriterRepository;
import com.bookstore.IT355_Project.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;
    @Override
    public List<Writer> findAll() {
        return writerRepository.findAll();
    }

    @Override
    public Optional<Writer> findById(Integer writerId) {
        return writerRepository.findById(writerId);
    }

    @Override
    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public Writer update(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public void deleteById(Integer writerId) {
        writerRepository.deleteById(writerId);
    }
}
