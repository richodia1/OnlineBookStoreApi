package com.book.onlinestore.dto;

import java.util.List;

public class CheckoutDTO {

    private Long userId;
    private String paymentMethod;

    public CheckoutDTO() {
    }

    public CheckoutDTO(Long userId, String paymentMethod) {
        this.userId = userId;
        this.paymentMethod = paymentMethod;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

