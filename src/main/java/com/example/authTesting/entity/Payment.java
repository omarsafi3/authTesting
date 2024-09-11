package com.example.authTesting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "Payments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String paymentType;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date PaymentDate;
    @CreationTimestamp
    @Column(updatable = false, name = "payment_time")
    private Instant PaymentTime;
    @Column(nullable = false)
    private Float totalPaid;

    @Column(nullable = false)
    private String details;
    @OneToOne(mappedBy = "payment")
    private Order order;

}
