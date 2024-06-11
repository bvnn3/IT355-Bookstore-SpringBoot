package com.bookstore.IT355_Project.service;

import com.bookstore.IT355_Project.entity.CartItem;
import com.bookstore.IT355_Project.repository.CartItemRepository;
import com.bookstore.IT355_Project.service.impl.CartItemServiceImpl;
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
public class CartItemServiceImplTest {
    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemServiceImpl cartItemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<CartItem> cartItems = Arrays.asList(new CartItem(), new CartItem());
        when(cartItemRepository.findAll()).thenReturn(cartItems);

        List<CartItem> result = cartItemService.findAll();

        assertEquals(cartItems, result);
        verify(cartItemRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int id = 1;
        CartItem cartItem = new CartItem();
        when(cartItemRepository.findById(id)).thenReturn(Optional.of(cartItem));

        Optional<CartItem> result = cartItemService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(cartItem, result.get());
        verify(cartItemRepository, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        int id = 1;
        when(cartItemRepository.findById(id)).thenReturn(Optional.empty());

        Optional<CartItem> result = cartItemService.findById(id);

        assertFalse(result.isPresent());
        verify(cartItemRepository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        CartItem cartItem = new CartItem();
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        CartItem result = cartItemService.save(cartItem);

        assertEquals(cartItem, result);
        verify(cartItemRepository, times(1)).save(cartItem);
    }

    @Test
    public void testUpdate() {
        CartItem cartItem = new CartItem();
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);

        CartItem result = cartItemService.update(cartItem);

        assertEquals(cartItem, result);
        verify(cartItemRepository, times(1)).save(cartItem);
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        doNothing().when(cartItemRepository).deleteById(id);

        cartItemService.deleteById(id);

        verify(cartItemRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeleteByIdNotFound() {
        int id = 999;
        doThrow(EmptyResultDataAccessException.class).when(cartItemRepository).deleteById(id);

        assertThrows(EmptyResultDataAccessException.class, () -> cartItemService.deleteById(id));
        verify(cartItemRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindByCartUserId() {
        int userId = 1;
        List<CartItem> cartItems = Arrays.asList(new CartItem(), new CartItem());
        when(cartItemRepository.findByCart_User_Id(userId)).thenReturn(cartItems);

        List<CartItem> result = cartItemService.findByCart_User_Id(userId);

        assertEquals(cartItems, result);
        verify(cartItemRepository, times(1)).findByCart_User_Id(userId);
    }

    @Test
    public void testFindByCartUserIdNotFound() {
        int userId = 1;
        when(cartItemRepository.findByCart_User_Id(userId)).thenReturn(Arrays.asList());

        List<CartItem> result = cartItemService.findByCart_User_Id(userId);

        assertTrue(result.isEmpty());
        verify(cartItemRepository, times(1)).findByCart_User_Id(userId);
    }

    @Test
    public void testDeleteByCartUserId() {
        int userId = 1;

        doNothing().when(cartItemRepository).deleteByCart_User_Id(userId);

        cartItemService.deleteByCart_User_Id(userId);

        verify(cartItemRepository, times(1)).deleteByCart_User_Id(userId);
    }
}
