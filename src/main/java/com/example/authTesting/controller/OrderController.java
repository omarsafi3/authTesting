package com.example.authTesting.controller;

import com.example.authTesting.entity.Order;
import com.example.authTesting.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    // Add a product (admin only)
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order p = orderService.addOrder(order);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Order> updateOrder(@RequestBody Order order,@PathVariable Long id) {
        Order p =orderService.updateOrder(id,order).orElseThrow(() -> new ResourceNotFoundException("not found"));
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    // Delete a product by ID (admin only)
    @DeleteMapping("/{id}")
        public void deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
        }

}
