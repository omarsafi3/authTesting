package com.example.authTesting.service.impl;


import com.example.authTesting.entity.Payment;
import com.example.authTesting.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("payment not found"));
    }
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setPaymentType(updatedPayment.getPaymentType());
                    payment.setTotalPaid(updatedPayment.getTotalPaid());
                    return paymentRepository.save(payment);
                });
    }
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
