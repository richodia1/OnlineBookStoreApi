package com.book.onlinestore.service;

import com.book.onlinestore.model.PurchaseHistory;
import com.book.onlinestore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseHistoryService {
    // Purchase History functionality
    List<PurchaseHistory> getPurchaseHistory(Long userId);
}
