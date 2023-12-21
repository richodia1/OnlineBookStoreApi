package com.book.onlinestore.repository;

import com.book.onlinestore.model.Invoice;

import com.book.onlinestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
   // List<Invoice> findByUser(User user);
     //Alternatively, you can use the following JPQL query
    @Query("SELECT i FROM Invoice i JOIN FETCH i.items WHERE i.user = :user")
    List<Invoice> findByUserWithItems(@Param("user") User user);
}

