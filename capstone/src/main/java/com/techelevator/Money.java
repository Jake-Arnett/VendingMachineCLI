package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal cash;
    private BigDecimal quarter = new BigDecimal("0.25");
    private BigDecimal dime = new BigDecimal("0.10");
    private BigDecimal nickel = new BigDecimal("0.05");

    public Money(BigDecimal cash) {
        this.cash = cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void getChange(BigDecimal cash){
        BigDecimal[] qChange = cash.divideAndRemainder(quarter);
        BigDecimal[] dChange = qChange[1].divideAndRemainder(dime);
        BigDecimal[] nChange = dChange[1].divideAndRemainder(nickel);

        System.out.printf("Change Given: %s Quarter(s), %s Dime(s), %s Nickel(s)\n\n", qChange[0], dChange[0], nChange[0]);
    }
}
