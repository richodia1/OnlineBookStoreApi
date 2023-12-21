package com.book.onlinestore.utility;

import java.util.Random;

public class StringUtillity {
    public static String generatePaymentReference() {

        int length = 6;

        // Define the range of digits (0-9)
        int minDigit = 0;
        int maxDigit = 9;

        // Use StringBuilder to efficiently build the reference
        StringBuilder paymentReferenceBuilder = new StringBuilder(length);
        Random random = new Random();

        // Generate each digit of the reference
        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(maxDigit - minDigit + 1) + minDigit;
            paymentReferenceBuilder.append(randomDigit);
        }

        return paymentReferenceBuilder.toString();
    }
}
