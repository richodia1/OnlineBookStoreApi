package com.book.onlinestore.controller;

import com.book.onlinestore.dto.CartItemDto;
import com.book.onlinestore.dto.CheckoutDTO;
import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartService;

    @PostMapping("/{userId}/add")
    public ResponseEntity<Void> addToCart(@PathVariable Long userId, @RequestBody CartItemDto cartItemDTO) {
        cartService.addToCart(userId, cartItemDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> viewCart(@PathVariable Long userId) {
        List<CartItem> cartItems = cartService.viewCart(userId);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody CheckoutDTO checkoutDTO) {
        // Simulate payment process
        String paymentStatus = simulatePaymentProcess(checkoutDTO);
        return ResponseEntity.ok(paymentStatus);
    }

    private String simulatePaymentProcess(CheckoutDTO checkoutDTO) {
        // Simulate payment process logic
        return "Payment Successful";
    }
}
