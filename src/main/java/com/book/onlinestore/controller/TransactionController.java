package com.book.onlinestore.controller;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.CartItemReqDto;
import com.book.onlinestore.dto.CheckoutDTO;
import com.book.onlinestore.dto.InvoiceDtoReq;
import com.book.onlinestore.payment.PaymentFactory;
import com.book.onlinestore.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/trans")
public class TransactionController {
    @Autowired(required = false)
    private TransactionService transactionService;

    @Autowired(required = false)
    private PaymentFactory paymentFactory;
    @PostMapping("/addtocart")
    public ResponseEntity<Void> addToCart(@RequestBody CartItemReqDto cartItemDTO) {
        transactionService.addToCart(cartItemDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/viewCart/{userId}")
    public ResponseEntity<ApiResponse> viewCart(@PathVariable Long userId) {
        var result = transactionService.viewCart(userId);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }

    @PostMapping("/checkout")
    public ResponseEntity<ApiResponse> checkout(@RequestBody CheckoutDTO checkoutDTO) {
          var result = transactionService.ProcessPayment(checkoutDTO);

        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }
    @GetMapping("/viewTransactionHistory/")
    public ResponseEntity<ApiResponse> viewTransactionHistory() {
        var result = transactionService.getPurchaseHistory();
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }


}
