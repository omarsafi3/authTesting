package com.example.authTesting.repository;

import com.example.authTesting.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    Optional<Products> findByName(String name);
}
