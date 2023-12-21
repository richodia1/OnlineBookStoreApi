package com.book.onlinestore.service;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.BookDtoReq;
import com.book.onlinestore.model.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {
    // Search functionality
    List<Book> searchBooks(String searchKey);

    ApiResponse AddBook(BookDtoReq bookDto);

    Optional<Book> getBookById(Long Id);

}
