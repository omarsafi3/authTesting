package com.example.authTesting.service.impl;

import com.example.authTesting.entity.Discount;
import com.example.authTesting.entity.Order;
import com.example.authTesting.repository.DiscountRepository;
import com.example.authTesting.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DiscountService {
    @Autowired
    private DiscountRepository discountRepository;
    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }
    public Optional<Discount> getDiscountById(Long id) {
        return discountRepository.findById(id);
    }
    public Discount addDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Optional<Discount> updateDiscount(Long id, Discount updatedDiscount) {
        return discountRepository.findById(id)
                .map(discount -> {
                    discount.setDiscount(updatedDiscount.getDiscount());
                    discount.setDiscountCode(updatedDiscount.getDiscountCode());
                    discount.setStatus(updatedDiscount.getStatus());
                    return discountRepository.save(discount);
                });
    }
    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }

}
