package com.book.onlinestore.dto;

public class BookDtoReq {
    private String title;
    private String genre;
    private String isbnCode;
    private String author;
    private int yearOfPublication;
    private double unitCost;
    public BookDtoReq(){}
    public BookDtoReq(String title, String genre, String isbnCode, String author, int yearOfPublication,double unitCost) {
        this.title = title;
        this.genre = genre;
        this.isbnCode = isbnCode;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.unitCost = unitCost;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
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
