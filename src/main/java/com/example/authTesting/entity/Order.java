package com.example.authTesting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String country;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false)
    private Float total;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String discountCode;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "discount_id", nullable = false)
    private Discount discount;
}
