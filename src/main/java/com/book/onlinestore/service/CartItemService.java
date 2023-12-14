package com.book.onlinestore.service;

import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {
    // Shopping Cart functionality
    List<CartItem> getUserCart(Long userId);

}
