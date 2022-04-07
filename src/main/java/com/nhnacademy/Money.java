package com.nhnacademy;

import com.nhnacademy.exception.InvalidCurrencyException;
import com.nhnacademy.exception.NegativeMoneyException;

public class Money {

    private final Currency currency;
    private final long longAmount;
    private final double doubleAmount;

    public static Money WON(long amount) {
        return new Money(Currency.WON, amount);
    }

    public static Money DOLLAR(double amount) {
        return new Money(Currency.DOLLAR, amount);
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return this.doubleAmount == 0 ? (double) this.longAmount : this.doubleAmount;
    }

    public Money add(Money money) {
        if (!money.getCurrency()
                  .equals(this.getCurrency())) {
            throw new IllegalArgumentException();
        }

        double resultAmount = money.getAmount() + this.getAmount();

        if (money.getCurrency() == Currency.WON) {
            return new Money(Currency.WON, (long) resultAmount);
        }

        return new Money(Currency.DOLLAR, resultAmount);
    }

    public Money subtract(Money money) {
        if (!money.getCurrency()
                  .equals(this.getCurrency())) {
            throw new InvalidCurrencyException();
        }

        System.out.println(this.getAmount() + " ==== " + money.getAmount());
        if (this.getAmount() < money.getAmount()) {
            throw new NegativeMoneyException();
        }

        double newAmount = this.getAmount() - money.getAmount();

        if (money.getCurrency() == Currency.WON) {
            return Money.WON((long) newAmount);
        }

        return new Money(money.getCurrency(), newAmount);
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

    private Money(Currency currency, long longAmount, double doubleAmount) {
//        if (longAmount < 0 || doubleAmount < 0) {
//            throw
//        }

        this.currency = currency;
        this.longAmount = longAmount;
        this.doubleAmount = doubleAmount;
    }


    public Money(Currency currency, long amount) {
        this(currency, Math.round(amount / 10.0) * 10, 0);
    }

    public Money(Currency currency, double amount) {
        this(currency, 0L, Math.round(100 * amount) / 100.0);
    }


}
