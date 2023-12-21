package com.book.onlinestore.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDetails {
   private List<CartItemDto> cartItemList = new ArrayList<>();
    private double TotalCost;

    public List<CartItemDto> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItemDto> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }
}
