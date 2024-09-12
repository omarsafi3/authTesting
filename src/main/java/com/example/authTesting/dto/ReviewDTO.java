package com.example.authTesting.dto;

import com.example.authTesting.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDTO {
    private Long id;
    private String text;
    private int rate;
    private Product product;
    private Long userId;


}
