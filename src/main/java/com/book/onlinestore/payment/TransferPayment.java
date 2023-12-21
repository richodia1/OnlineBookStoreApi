package com.book.onlinestore.payment;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.CheckoutDTO;
import com.book.onlinestore.utility.StringUtillity;

public class TransferPayment implements PaymentService{
    @Override
    public ApiResponse processPayment(CheckoutDTO checkoutDTO) {
        return new ApiResponse(200,"Transfer successful", "Payment reference :"+StringUtillity.generatePaymentReference());

    }
}
