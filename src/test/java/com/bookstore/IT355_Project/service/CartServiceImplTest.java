package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.Cart;
import com.bookstore.IT355_Project.repository.CartRepository;
import com.bookstore.IT355_Project.service.impl.CartServiceImpl;
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
public class CartServiceImplTest {
    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Cart> carts = Arrays.asList(new Cart(), new Cart());
        when(cartRepository.findAll()).thenReturn(carts);

        List<Cart> result = cartService.findAll();

        assertEquals(carts, result);
        verify(cartRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        Cart cart = new Cart();
        when(cartRepository.findById(id)).thenReturn(Optional.of(cart));

        Optional<Cart> result = cartService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(cart, result.get());
        verify(cartRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(cartRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Cart> result = cartService.findById(id);

        assertFalse(result.isPresent());
        verify(cartRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Cart cart = new Cart();
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart result = cartService.save(cart);

        assertEquals(cart, result);
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    public void testUpdate() {
        Cart cart = new Cart();
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart result = cartService.update(cart);

        assertEquals(cart, result);
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(cartRepository).deleteById(id);

        cartService.deleteById(id);

        verify(cartRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(cartRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> cartService.deleteById(id));
        verify(cartRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByUserId() {
        int userId = 1;
        Cart cart = new Cart();
        when(cartRepository.findByUser_Id(userId)).thenReturn(Optional.of(cart));

        Optional<Cart> result = cartService.findByUser_Id(userId);

        assertTrue(result.isPresent());
        assertEquals(cart, result.get());
        verify(cartRepository, times(1)).findByUser_Id(userId);
    }

    @Test
    public void testFindByUserIdNotFound() {
        int userId = 1;
        when(cartRepository.findByUser_Id(userId)).thenReturn(Optional.empty());

        Optional<Cart> result = cartService.findByUser_Id(userId);

        assertFalse(result.isPresent());
        verify(cartRepository, times(1)).findByUser_Id(userId);
    }
}
