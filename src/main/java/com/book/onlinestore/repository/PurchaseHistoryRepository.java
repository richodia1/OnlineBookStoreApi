package com.book.onlinestore.repository;

import com.book.onlinestore.model.PurchaseHistory;
import com.book.onlinestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    List<PurchaseHistory> findByUser(User user);
}

