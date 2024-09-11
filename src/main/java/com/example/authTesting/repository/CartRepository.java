package com.example.authTesting.repository;

import com.example.authTesting.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public List<Cart> findByUserId(Long userId);
    public void deleteByUserId(Long userId);
}
