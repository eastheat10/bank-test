package com.nhnacademy;

public class Money{

    private final Currency currency;
    private final long longAmount;
    private final double doubleAmount;

    public Money(Currency currency, long amount) {
        this(currency, amount, 0);
    }

    public Money(Currency currency, double amount) {
        this(currency, 0L, amount);
    }

    private Money(Currency currency, long longAmount, double doubleAmount) {
        this.currency = currency;
        this.longAmount = longAmount;
        this.doubleAmount = doubleAmount;
    }

    public Currency getCurrency() {

        return currency;
    }

    public double getAmount() {
        return this.doubleAmount == 0 ? (double) this.longAmount : this.doubleAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return (currency.equals(money.getCurrency())
            && (this.getAmount() == money.getAmount()));

    }

}
