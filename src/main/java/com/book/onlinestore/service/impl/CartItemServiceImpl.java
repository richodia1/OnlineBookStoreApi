package com.book.onlinestore.service.impl;

import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.CartItemRepository;
import com.book.onlinestore.repository.UserRepository;
import com.book.onlinestore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<CartItem> viewCart(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return cartItemRepository.findByUser(user.get());
    }
}
