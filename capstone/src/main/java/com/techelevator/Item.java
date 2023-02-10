package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Item {
    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String type;
    private int quantity;

    public Item(String slotLocation, String productName, BigDecimal price, String type, int quantity) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {return quantity;}

    @Override
    public String toString(){
        return getSlotLocation()+" | "+getProductName()+" | "+getPrice()+" | "+getType()+" | "+getQuantity();
    }
    public void decreaseQuantity(){
        if (quantity!=0){
            this.quantity -=1;
        }
    }


}
