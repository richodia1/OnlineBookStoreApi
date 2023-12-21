package com.book.onlinestore.payment;

public interface PaymentFactory {
    PaymentService createPaymentMethod(PaymentMethodType paymentMethodType);
}
