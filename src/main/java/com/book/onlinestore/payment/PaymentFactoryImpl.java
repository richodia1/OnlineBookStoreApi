package com.book.onlinestore.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentFactoryImpl implements PaymentFactory{
    @Override
    public PaymentService createPaymentMethod(PaymentMethodType paymentMethodType) {
        switch (paymentMethodType) {
            case USSD:
                return new UssdPayment();
            case WEB:
                return new WebPayment();
            case TRANSFER:
                return new TransferPayment();
            default:
                throw new IllegalArgumentException("Invalid payment method type selected");
        }
    }
}
