package com.book.onlinestore.service;

import com.book.onlinestore.dto.*;
import com.book.onlinestore.model.*;
import com.book.onlinestore.payment.PaymentFactory;
import com.book.onlinestore.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    InvoiceItemRepository invoiceItemRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired(required = false)
    private PaymentFactory paymentFactory;
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
            CartDetails dta = new CartDetails();
            dta.setCartItemList(rtnCartItems);
            //
            Double totalCost = rtnCartItems.stream()
                    .mapToDouble(obj -> obj.getUnitCost() * obj.getQuantity())
                    .sum();
            dta.setTotalCost(totalCost);
            return new ApiResponse(200, "Success", dta);
        }catch (Exception ex) {

            return new ApiResponse(404, "No record found", rtn);
        }

    }
    @Transactional
    @Override
    public ApiResponse CreateInvoice(InvoiceDtoReq req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + req.getUserId()));
        ApiResponse api = new ApiResponse();
        Invoice inv = new Invoice();
       inv.setUser(user);
        LocalDate today = LocalDate.now();
       inv.setDateIssued(today);
       inv.setPaymentReference("Ieieiu3");
       inv.setPaymentMethod("USSD");
       var createdInvoice = invoiceRepository.save(inv);
        api.setMessage("Success");
        api.setStatusCode(200);
        api.setData(createdInvoice);
       return api;
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

    @Transactional
    @Override
    public ApiResponse ProcessPayment(CheckoutDTO checkoutDTO) {
        var paymentProcessingMethod = paymentFactory.createPaymentMethod(checkoutDTO.getPaymentMethod());
        var paymentResult = paymentProcessingMethod.processPayment(checkoutDTO);
        try {
            Long userId = null;
            if (paymentResult.getStatusCode() == 200) {
                // get cart item

                userId = checkoutDTO.getUserId();
                Optional<User> user = userRepository.findById(userId);
                var cartItemList = cartItemRepository.findByUser(user.get());
                String[] arr = paymentResult.getData().toString().split(":");
                if (cartItemList.size() > 0) {
                    LocalDate today = LocalDate.now();
                    Invoice invoice = new Invoice();
                    invoice.setPaymentMethod(checkoutDTO.getPaymentMethod().toString());
                    invoice.setPaymentStatus("Success");
                    invoice.setUser(user.get());
                    invoice.setTotalAmount(checkoutDTO.getTotalPayement());
                    invoice.setPaymentReference(arr[1].toString());
                    invoice.setDateIssued(today);
                    List<InvoiceItem> items = new ArrayList<>();
                    var Createdinvoice = invoiceRepository.save(invoice);
                    System.out.println("invoice item just persisted is :"+ Createdinvoice.getId());
                    for (CartItem cartItem : cartItemList) {
                        InvoiceItem invoiceItem = new InvoiceItem();
                        invoiceItem.setItemName(cartItem.getBook().getTitle());
                        invoiceItem.setQuantity(cartItem.getQuantity());
                        invoiceItem.setUnitCost(cartItem.getBook().getUnitCost());
                        invoiceItem.setInvoice(Createdinvoice);
                       var justCreateditem =  invoiceItemRepository.save(invoiceItem);

                        System.out.println("new item just "+ justCreateditem.getId());

                        cartItemRepository.delete(cartItem); // remove from cart
                    }



                }


            }
        }catch (Exception ex){

        }
        return  paymentResult;

    }

    @Override
    public ApiResponse getPurchaseHistory() {
        ApiResponse api = new ApiResponse();
        try {

            var purHistories = invoiceRepository.findAll();
            api.setMessage("Success");
            api.setStatusCode(200);
            api.setData(purHistories);
        }catch (Exception ex){
            System.out.println("Error fetching History is :"+ ex.getMessage());
        }
        return api;
    }

}


