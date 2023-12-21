package com.book.onlinestore.dao;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.BookDto;
import com.book.onlinestore.dto.BookDtoReq;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.repository.BookRepository;
import com.book.onlinestore.service.BookService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookDaoTest {
    public static Book book;
    public static BookDtoReq bookDto;
    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    @BeforeAll
    public static void setUp() {


        bookDto = new BookDtoReq("Eze goes to School", "genre1", "1234-345","chinue Achebe", 1991,10.0);

        book = new Book(1,"Eze goes to School", "genre1", "1234-345","chinue Achebe", 1991,10.0);
    }

    @Test
    void saveBook() {
        when(bookRepository.save(book)).thenReturn(book);

        Book netbook = bookRepository.save(book);

        verify(bookRepository, times(1)).save(book);
        assertEquals(netbook, book);
        assertEquals(book.getTitle(),  netbook.getTitle());
        assertEquals(book.getGenre(),  netbook.getGenre());
    }
// other test coming soon

}

