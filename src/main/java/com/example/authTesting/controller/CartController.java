package com.example.authTesting.controller;

import com.example.authTesting.entity.Cart;
import com.example.authTesting.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/cart")
public class CartController {
    @Autowired
    private CartService cartService;


}
