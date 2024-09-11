package com.example.authTesting.controller;

import com.example.authTesting.entity.Discount;
import com.example.authTesting.service.impl.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user/discounts")
@RestController
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @GetMapping
    public ResponseEntity<?> getAllDiscount() {
        return new ResponseEntity<>(discountService.getAllDiscount(), HttpStatus.OK);
    }

    // Add a product (admin only)
    @PostMapping("/add")
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount) {
        Discount p = discountService.addDiscount(discount);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Discount> updateDiscount(@RequestBody Discount discount,@PathVariable Long id) {
        Discount p =discountService.updateDiscount(id,discount).orElseThrow(() -> new ResourceNotFoundException("not found"));
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable Long id) {
        discountService.deleteDiscount(id);
    }
}
