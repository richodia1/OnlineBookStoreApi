package com.book.onlinestore.service;

import com.book.onlinestore.dto.BookDto;
import com.book.onlinestore.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    // Search functionality
    List<Book> searchBooks(String title, String author, int yearOfPublication, String genre);
    void AddBook(BookDto book);
}
