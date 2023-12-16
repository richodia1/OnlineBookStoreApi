package com.book.onlinestore.service.impl;

import com.book.onlinestore.dto.BookDto;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.repository.BookRepository;
import com.book.onlinestore.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> searchBooks(String title, String author, int yearOfPublication, String genre) {
        return bookRepository.findByTitleOrAuthorOrYearOfPublicationOrGenre(title, author,yearOfPublication,genre);
    }

    @Override
    public void AddBook(BookDto book) {
        ModelMapper modelMapper = new ModelMapper();
        Book bookEntity = modelMapper.map(book,Book.class);
        bookRepository.save(bookEntity);
    }

    @Override
    public Optional<Book> getBookById(Long Id) {
        return bookRepository.findById(Id);
    }
}
