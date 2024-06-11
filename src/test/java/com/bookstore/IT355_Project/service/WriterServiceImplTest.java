package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Writer;
import com.bookstore.IT355_Project.repository.WriterRepository;
import com.bookstore.IT355_Project.service.impl.WriterServiceImpl;
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

public class WriterServiceImplTest {
    @Mock
    private WriterRepository writerRepository;

    @InjectMocks
    private WriterServiceImpl writerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Writer> writers = Arrays.asList(new Writer(), new Writer());
        when(writerRepository.findAll()).thenReturn(writers);

        List<Writer> result = writerService.findAll();

        assertEquals(writers, result);
        verify(writerRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Writer writer = new Writer();
        when(writerRepository.findById(id)).thenReturn(Optional.of(writer));

        Optional<Writer> result = writerService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(writer, result.get());
        verify(writerRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(writerRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Writer> result = writerService.findById(id);

        assertFalse(result.isPresent());
        verify(writerRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Writer writer = new Writer();
        when(writerRepository.save(writer)).thenReturn(writer);

        Writer result = writerService.save(writer);

        assertEquals(writer, result);
        verify(writerRepository, times(1)).save(writer);
    }

    @Test
    public void testUpdate() {
        Writer writer = new Writer();
        when(writerRepository.save(writer)).thenReturn(writer);

        Writer result = writerService.update(writer);

        assertEquals(writer, result);
        verify(writerRepository, times(1)).save(writer);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(writerRepository).deleteById(id);

        writerService.deleteById(id);

        verify(writerRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(writerRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> writerService.deleteById(id));
        verify(writerRepository, times(1)).deleteById(id);
    }
}
