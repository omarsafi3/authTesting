package com.example.authTesting.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;



@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column( nullable = false)
    private int price;
    @Column(nullable = false)
    private String quantity;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
    private String description;
}