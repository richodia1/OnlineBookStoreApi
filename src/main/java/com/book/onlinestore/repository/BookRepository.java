package com.book.onlinestore.repository;

import com.book.onlinestore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCaseOrIsbnCodeContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrYearOfPublication(
            String title, String genre, String isbnCode, String author, int yearOfPublication
    );

}

