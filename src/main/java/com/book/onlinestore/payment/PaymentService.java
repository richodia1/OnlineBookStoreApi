package com.book.onlinestore.payment;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.CheckoutDTO;

public interface PaymentService {
    ApiResponse processPayment(CheckoutDTO checkoutDTO);
}

