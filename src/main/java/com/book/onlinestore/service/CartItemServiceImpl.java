package com.book.onlinestore.service;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.CartItemDto;
import com.book.onlinestore.dto.CartItemReqDto;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.model.CartItem;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.BookRepository;
import com.book.onlinestore.repository.CartItemRepository;
import com.book.onlinestore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

class CartItemServiceImpl implements CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public ApiResponse viewCart(Long userId) {
        List<CartItemDto> rtn = new ArrayList<>();
        try {
            Optional<User> user = userRepository.findById(userId);
            if (user.get() == null) {
                return new ApiResponse(400, "No such user exist with Id :" + userId, "");
            }
            var cartItemList = cartItemRepository.findByUser(user.get());
            if (cartItemList == null) {
                return new ApiResponse(404, "No cart exist for user with Id :" + userId, "") {
                };
            }
            var rtnCartItems = cartItemList.stream()
                    .map(CartItem::toDto)
                    .collect(Collectors.toList());
            return new ApiResponse(200, "Success", rtnCartItems);
        }catch (Exception ex) {

            return new ApiResponse(404, "No record found", rtn);
        }

    }

    @Override
    public void addToCart(CartItemReqDto cartItemDTO) {

        User user = userRepository.findById(cartItemDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + cartItemDTO.getUserId()));

        Book book = bookRepository.findById(cartItemDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + cartItemDTO.getBookId()));
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setUser(user);

        cartItemRepository.save(cartItem);
    }

}
