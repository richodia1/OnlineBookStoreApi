package com.book.onlinestore.service.impl;

import com.book.onlinestore.model.PurchaseHistory;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.PurchaseHistoryRepository;
import com.book.onlinestore.repository.UserRepository;
import com.book.onlinestore.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;
    @Override
    public List<PurchaseHistory> getPurchaseHistory(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        return purchaseHistoryRepository.findByUser(user.get());
    }
}
