package com.book.onlinestore.dto;

import java.time.LocalDate;

  public class InvoiceDtoReq {
    private String paymentMethod;
    private String paymentReference;
    private String PaymentStatus;
    private double totalAmount;
    private LocalDate dateIssued;
      private Long UserId;

      public String getPaymentMethod() {
          return paymentMethod;
      }

      public void setPaymentMethod(String paymentMethod) {
          this.paymentMethod = paymentMethod;
      }

      public String getPaymentReference() {
          return paymentReference;
      }

      public void setPaymentReference(String paymentReference) {
          this.paymentReference = paymentReference;
      }

      public String getPaymentStatus() {
          return PaymentStatus;
      }

      public void setPaymentStatus(String paymentStatus) {
          PaymentStatus = paymentStatus;
      }

      public double getTotalAmount() {
          return totalAmount;
      }

      public void setTotalAmount(double totalAmount) {
          this.totalAmount = totalAmount;
      }

      public LocalDate getDateIssued() {
          return dateIssued;
      }

      public void setDateIssued(LocalDate dateIssued) {
          this.dateIssued = dateIssued;
      }

      public Long getUserId() {
          return UserId;
      }

      public void setUserId(Long userId) {
          UserId = userId;
      }
  }
