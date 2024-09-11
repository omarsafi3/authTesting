package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Order;
import com.example.authTesting.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setCountry(updatedOrder.getCountry());
                    order.setTotal(updatedOrder.getTotal());
                    order.setDiscountCode(updatedOrder.getDiscountCode());
                    order.setStatus(updatedOrder.getStatus());
                    return orderRepository.save(order);
                });
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
