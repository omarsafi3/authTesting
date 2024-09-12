package com.example.authTesting.dto;

import com.example.authTesting.entity.Cart;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private List<ReviewDTO> reviews;
    // Add other fields as needed
}

