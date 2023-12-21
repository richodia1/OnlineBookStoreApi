package com.book.onlinestore.repository;

import com.book.onlinestore.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
}
