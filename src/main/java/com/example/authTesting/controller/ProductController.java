package com.example.authTesting.controller;

import com.example.authTesting.entity.Products;
import com.example.authTesting.service.impl.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/admin/products")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Add a product (admin only)
    @PostMapping("/add")
    public String addProduct(@RequestBody Products products) {
        return productService.addProduct(products);
    }

    // Delete a product by ID (admin only)
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
