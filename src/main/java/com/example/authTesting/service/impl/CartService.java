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

    public List<Cart> getAllCarts() {
        return CartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return CartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart not found"));
    }

    public List<Cart> getCartsByUserId(Long userId) {
        return CartRepository.findByUserId(userId);
    }
    public Cart addCart(Cart cart) {
        return CartRepository.save(cart);
    }
    public Cart updateCart(Cart cart) {
        return CartRepository.save(cart);
    }
    public void deleteCartByUserId(Long id) {
        cartRepository.deleteByUserId(id);
    }
}
