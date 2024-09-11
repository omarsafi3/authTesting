package com.example.authTesting.controller;

import com.example.authTesting.entity.Category;
import com.example.authTesting.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
    @PutMapping("/{id}")
    public Optional<Category> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
