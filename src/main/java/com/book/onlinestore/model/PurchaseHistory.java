package com.book.onlinestore.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime purchaseTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    // Other methods as needed

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", purchaseTime=" + purchaseTime +
                '}';
    }
}
