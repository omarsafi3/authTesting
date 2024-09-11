package com.example.authTesting.repository;

import com.example.authTesting.entity.Category;
import com.example.authTesting.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
