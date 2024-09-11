package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Cart;
import com.example.authTesting.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
public class CartService {
    @Autowired
    private CartRepository CartRepository;
    @Autowired
    private CartRepository cartRepository;


    public List<Cart> getCartItemsByUserId(Long userId) {
        return CartRepository.findByUserId(userId);
    }

    public Cart addCartItem(Cart cart) {
        return CartRepository.save(cart);
    }

    public Cart updateCartItem(Cart cart) {
        return CartRepository.save(cart);
    }

    public void deleteCartItemByUserId(Long id) {
        cartRepository.deleteByUserId(id);
    }
}
