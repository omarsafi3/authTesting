package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Product;
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

    public Product addProduct(Product product) {
        return repository.save(product);

    }
    public void deleteProductById(int id) {
        repository.deleteById(id);
    }
    public Optional<Product> getProductByName(String name) {
        return repository.findByName(name);
    }
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return repository.findById(id);
    }

    public Optional<Product> updateProduct(int id,Product updatedProduct) {
        return repository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setQuantity(updatedProduct.getQuantity());
                    product.setDescription(updatedProduct.getDescription());
                    return repository.save(product);
                });
    }
}
