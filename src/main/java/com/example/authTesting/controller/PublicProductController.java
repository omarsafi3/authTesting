package com.example.authTesting.controller;

import com.example.authTesting.entity.Products;
import com.example.authTesting.service.impl.ProductService;
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
    public Optional<Products> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Get all products (public)
    @GetMapping("/")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
}

