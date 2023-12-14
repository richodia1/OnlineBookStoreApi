package com.book.onlinestore.dto;

import java.io.Serializable;

public class CartItemDto implements Serializable {
    private BookDto book;
    private UserDto user;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
