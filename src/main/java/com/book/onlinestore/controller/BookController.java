package com.book.onlinestore.controller;

import com.book.onlinestore.dto.*;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired(required = false)
    private BookService bookService;
    @PostMapping("/addbook")
    public ResponseEntity<ApiResponse> addbook(@RequestBody BookDtoReq book) {
         var result = bookService.AddBook(book);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent())
        return ResponseEntity.ok(book.get());
        return (ResponseEntity<Book>) ResponseEntity.notFound();
    }


    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String searchKey
                                                  ) {
        List<Book> books = bookService.searchBooks(searchKey);
        return ResponseEntity.ok(books);
    }
}
