package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Products;
import com.example.authTesting.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String addProduct(Products products) {
        repository.save(products);
        return "product Added Successfully";
    }
    public String deleteProductById(int id) {
        repository.deleteById(id);
        return "Product deleted successfully";
    }
    public Optional<Products> getProductByName(String name) {
        return repository.findByName(name);
    }
    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Products> getProductById(int id) {
        return repository.findById(id);
    }
}
