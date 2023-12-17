package com.book.onlinestore.controller;

import com.book.onlinestore.dto.PurchaseHistoryDto;
import com.book.onlinestore.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchasehistory")
public class PurchaseHistoryController {
    @Autowired(required = false)
 private PurchaseHistoryService purchaseHistoryService;



    @GetMapping("/{userId}")
    public ResponseEntity<List<PurchaseHistoryDto>> getPurchaseHistory(@PathVariable Long userId) {
        List<PurchaseHistoryDto> purchaseHistory = purchaseHistoryService.getPurchaseHistory(userId);
        return ResponseEntity.ok(purchaseHistory);
    }
}
