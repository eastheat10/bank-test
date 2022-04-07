package com.nhnacademy;

import com.nhnacademy.exception.InvalidCurrencyException;

public class Bank implements Exchangable {
    private final static double EXCHANGE_FEE = 0.05;


    public Money exchange(Money money, Currency currency) {


        if (money.getCurrency() == currency) {
            throw new InvalidCurrencyException();
        }

        if (money.getCurrency() == Currency.WON) {
            double amount = money.getAmount() / 1000;
            amount -= getExchangedFee(money);

            return Money.WON();
        }

        if (money.getCurrency() == Currency.DOLLAR) {
            long amount = (long) money.getAmount() * 1000;
            amount -= getExchangedFee(money);
            return Money.DOLLAR();
        }
        return null;
    }

    @Override
    public double getExchangedFee(Money money) {
        double amount = money.getAmount() * EXCHANGE_FEE;

        return amount;
    }


}
