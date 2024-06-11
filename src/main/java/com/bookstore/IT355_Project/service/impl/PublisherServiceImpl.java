package com.bookstore.IT355_Project.service.impl;

import com.bookstore.IT355_Project.entity.Publisher;
import com.bookstore.IT355_Project.repository.PublisherRepository;
import com.bookstore.IT355_Project.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Integer publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
