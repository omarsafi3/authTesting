package com.example.authTesting.controller;

import com.example.authTesting.entity.Category;
import com.example.authTesting.entity.Product;
import com.example.authTesting.repository.CategoryRepository;
import com.example.authTesting.service.impl.ProductService;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/api/v1/user/products")
@RestController
public class ProductController {
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }


    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description")  String description,
            @RequestParam("price")  int price,
            @RequestParam("quantity")  int quantity,
            @RequestParam("photo") MultipartFile photo) {

        try {
            // Validate photo
            if (photo.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            // Convert MultipartFile to byte[] (for saving as BLOB)
            byte[] photoBytes = photo.getBytes();

            // Create a new Product object with the provided data
            Product product = new Product(name, description, price, quantity, photoBytes);
            Optional<Category> category = categoryRepository .findById(1L);
            product.setCategory(category.get());

            // Save the product using the service
            Product savedProduct = productService.addProduct(product);

            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } catch (Exception e) {
            // Use a logging framework instead of e.printStackTrace()

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long id) {
        Product p =productService.updateProduct(id,product).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    // Delete a product by ID (admin only)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id); // Assuming your service has such a method.
        if (deleted) {
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

}
