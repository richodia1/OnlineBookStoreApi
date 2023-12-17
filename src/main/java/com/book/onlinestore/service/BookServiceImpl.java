package com.book.onlinestore.service;

import com.book.onlinestore.dto.BookDto;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> searchBooks(String searchKey) {
        return bookRepository.findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrIsbnCodeContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrYearOfPublication(
                searchKey, searchKey, searchKey, searchKey, parseYear(searchKey));

    }

    @Override
    public void AddBook(BookDto book) {
        ModelMapper modelMapper = new ModelMapper();
        Book bookEntity = modelMapper.map(book, Book.class);
        bookRepository.save(bookEntity);
    }

    @Override
    public Optional<Book> getBookById(Long Id) {
        return bookRepository.findById(Id);
    }
    private int parseYear(String searchKey) {
        try {
            return Integer.parseInt(searchKey);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if the year is not a valid number
        }
    }
}
