package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal cash;

    public Money(BigDecimal cash) {
        this.cash = cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getCash() {
        return cash;
    }
}
