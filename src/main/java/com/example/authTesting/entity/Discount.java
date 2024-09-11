package com.example.authTesting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Discounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String discountCode;
    @Column(nullable = false)
    private Float discount;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
    @Column(nullable = false)
    private String status;



    @OneToMany(mappedBy = "discount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

}

