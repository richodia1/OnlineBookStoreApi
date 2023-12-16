package com.book.onlinestore.dto;

import java.util.List;

public class CheckoutDTO {

    private Long userId;
    private List<Long> bookIds;
    private String paymentMethod;

    public CheckoutDTO() {
    }

    public CheckoutDTO(Long userId, List<Long> bookIds, String paymentMethod) {
        this.userId = userId;
        this.bookIds = bookIds;
        this.paymentMethod = paymentMethod;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

