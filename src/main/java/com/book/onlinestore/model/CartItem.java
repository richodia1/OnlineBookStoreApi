package com.book.onlinestore.model;

import com.book.onlinestore.dto.CartItemDto;
import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int quantity;
// Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Other methods as needed
    public CartItemDto toDto() {
        CartItemDto dto = new CartItemDto();
        dto.setBookId(this.book.getId());

        dto.setQuantity(this.quantity);
        dto.setUnitCost(this.book.getUnitCost());
        dto.setBookTitle(this.book.getTitle());
        return dto;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}

