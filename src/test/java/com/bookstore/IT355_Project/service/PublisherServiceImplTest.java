package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Publisher;
import com.bookstore.IT355_Project.repository.PublisherRepository;
import com.bookstore.IT355_Project.service.impl.PublisherServiceImpl;
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
public class PublisherServiceImplTest {
    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Publisher> publishers = Arrays.asList(new Publisher(), new Publisher());
        when(publisherRepository.findAll()).thenReturn(publishers);

        List<Publisher> result = publisherService.findAll();

        assertEquals(publishers, result);
        verify(publisherRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Publisher publisher = new Publisher();
        when(publisherRepository.findById(id)).thenReturn(Optional.of(publisher));

        Optional<Publisher> result = publisherService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(publisher, result.get());
        verify(publisherRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(publisherRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Publisher> result = publisherService.findById(id);

        assertFalse(result.isPresent());
        verify(publisherRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Publisher publisher = new Publisher();
        when(publisherRepository.save(publisher)).thenReturn(publisher);

        Publisher result = publisherService.save(publisher);

        assertEquals(publisher, result);
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    public void testUpdate() {
        Publisher publisher = new Publisher();
        when(publisherRepository.save(publisher)).thenReturn(publisher);

        Publisher result = publisherService.update(publisher);

        assertEquals(publisher, result);
        verify(publisherRepository, times(1)).save(publisher);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(publisherRepository).deleteById(id);

        publisherService.deleteById(id);

        verify(publisherRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(publisherRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> publisherService.deleteById(id));
        verify(publisherRepository, times(1)).deleteById(id);
    }
}