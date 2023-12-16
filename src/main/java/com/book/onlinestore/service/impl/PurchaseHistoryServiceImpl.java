package com.book.onlinestore.service.impl;

import com.book.onlinestore.dto.PurchaseHistoryDto;
import com.book.onlinestore.model.PurchaseHistory;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.PurchaseHistoryRepository;
import com.book.onlinestore.repository.UserRepository;
import com.book.onlinestore.service.PurchaseHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;
    @Override
    public List<PurchaseHistoryDto> getPurchaseHistory(Long userId) {
        Optional<User> user = userRepository.findById(userId);
       var purHistories = purchaseHistoryRepository.findByUser(user.get());
        ModelMapper modelMapper = new ModelMapper();
        List<PurchaseHistoryDto> rtnPurchaseHistories = purHistories
                .stream()
                .map(purHistory -> modelMapper.map(purHistory, PurchaseHistoryDto.class))
                .collect(Collectors.toList());
        return rtnPurchaseHistories;
    }
}
