package com.example.authTesting.controller;

import com.example.authTesting.entity.Cart;
import com.example.authTesting.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    @PostMapping("/add")
    public Cart addCartItem(Cart cart) {
        return cartService.addCartItem(cart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartItemByUserId(@PathVariable Long id) {
        cartService.deleteCartItemByUserId(id);
    }


}
