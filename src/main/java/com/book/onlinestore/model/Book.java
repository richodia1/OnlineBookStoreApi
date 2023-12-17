package com.book.onlinestore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String title;
    private String genre;
    private String isbnCode;
    private String author;
    private int yearOfPublication;
    private double unitCost;



    // Constructors
    public Book() {
    }

    public Book(String title, String genre, String isbnCode, String author, int yearOfPublication,double unitCost) {
        this.title = title;
        this.genre = genre;
        this.isbnCode = isbnCode;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.unitCost = unitCost;
    }

    // Getters and Setters


    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
