package com.book.onlinestore.dto;

import com.book.onlinestore.payment.PaymentMethodType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CheckoutDTO {
    private Long userId;
    private double TotalPayement;
    private PaymentMethodType paymentMethod;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getTotalPayement() {
        return TotalPayement;
    }

    public void setTotalPayement(double totalPayement) {
        TotalPayement = totalPayement;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

