package com.example.authTesting.controller;

import com.example.authTesting.entity.Product;
import com.example.authTesting.service.impl.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/public/products")
@RestController
public class PublicProductController {
    private final ProductService productService;

    public PublicProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get product by ID (public)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    // Get all products (public)
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
}

