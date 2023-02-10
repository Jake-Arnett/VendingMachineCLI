package com.techelevator;

public class Money {
    private int cash = 0;

    public Money(int cash) {
        this.cash = cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }
}
