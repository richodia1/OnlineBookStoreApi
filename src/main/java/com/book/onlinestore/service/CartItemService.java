package com.book.onlinestore.service;

import com.book.onlinestore.dto.CartItemDto;
import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface CartItemService {
    // Shopping Cart functionality
    List<CartItem> viewCart(Long userId);
    void addToCart(Long userId,CartItemDto cartItemDTO);

}
