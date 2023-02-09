package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String slotLocation;
    private String productName;
    private String price;
    private String type;

    public Item(String slotLocation, String productName, String price, String type) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

//    @Override
//    public String toString(){
//        return getSlotLocation()+" | "+getProductName()+" | "+getPrice()+" | "+getType();
//    }



}
