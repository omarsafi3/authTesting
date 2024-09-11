package com.example.authTesting.controller;

import com.example.authTesting.entity.Product;
import com.example.authTesting.entity.Review;
import com.example.authTesting.service.impl.ProductService;

import com.example.authTesting.service.impl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/api/v1/user/review")
@RestController
public class ReviewController {
    @Autowired
    private  ReviewService reviewService;



    // Add a product (admin only)
    @PostMapping("/add")
    public ResponseEntity<Review> addProduct(@RequestBody Review review) {
        Review p =reviewService.addReview(review);
        return new ResponseEntity<>(p, HttpStatus.OK) ;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateProduct(@RequestBody Review review,@PathVariable Long id) {
        Review p =reviewService.updateReview(id,review).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    // Delete a product by ID (admin only)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
