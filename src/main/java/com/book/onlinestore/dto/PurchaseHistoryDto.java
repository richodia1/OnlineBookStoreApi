package com.book.onlinestore.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PurchaseHistoryDto implements Serializable {

    private BookDto book;
    private UserDto user;
    private LocalDateTime purchaseTime;

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}
