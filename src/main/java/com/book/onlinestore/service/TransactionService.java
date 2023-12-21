package com.book.onlinestore.service;

import com.book.onlinestore.dto.*;
import com.book.onlinestore.model.*;
import com.book.onlinestore.payment.PaymentFactory;
import com.book.onlinestore.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface TransactionService {
    // Shopping Cart functionality
    ApiResponse viewCart(Long userId);
    ApiResponse CreateInvoice(InvoiceDtoReq  req);
    void addToCart(CartItemReqDto cartItemDTO);
    ApiResponse ProcessPayment(CheckoutDTO checkoutDTO);

    ApiResponse getPurchaseHistory();

}


