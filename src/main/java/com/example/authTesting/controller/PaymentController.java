package com.example.authTesting.controller;

import com.example.authTesting.entity.Payment;
import com.example.authTesting.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user/payments")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    // Add a product (admin only)
    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment p = paymentService.addPayment(payment);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Payment> updatePayment(@RequestBody Payment payment,@PathVariable Long id) {
        Payment p =paymentService.updatePayment(id,payment).orElseThrow(() -> new ResourceNotFoundException("not found"));
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    // Delete a product by ID (admin only)
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
