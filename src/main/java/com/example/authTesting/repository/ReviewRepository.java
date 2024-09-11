package com.example.authTesting.repository;

import com.example.authTesting.entity.Product;
import com.example.authTesting.entity.RefreshToken;
import com.example.authTesting.entity.Review;

import com.example.authTesting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByProduct(Product product);
    Optional<Review> findByUser(User user);
}

