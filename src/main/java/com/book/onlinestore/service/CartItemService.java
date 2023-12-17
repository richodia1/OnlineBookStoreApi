package com.book.onlinestore.service;

import com.book.onlinestore.dto.*;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.BookRepository;
import com.book.onlinestore.repository.CartItemRepository;
import com.book.onlinestore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface CartItemService {
    // Shopping Cart functionality
    ApiResponse viewCart(Long userId);
    void addToCart(CartItemReqDto cartItemDTO);




}
