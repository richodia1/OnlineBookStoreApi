package com.book.onlinestore.controller;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.CartItemDto;
import com.book.onlinestore.dto.CartItemReqDto;
import com.book.onlinestore.dto.CheckoutDTO;
import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartItemController {
    @Autowired(required = false)
    private CartItemService cartService;

    @PostMapping("/{userId}/add")
    public ResponseEntity<Void> addToCart(@RequestBody CartItemReqDto cartItemDTO) {
        cartService.addToCart(cartItemDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/viewCart/{userId}")
    public ResponseEntity<ApiResponse> viewCart(@PathVariable Long userId) {
        var result = cartService.viewCart(userId);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
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
