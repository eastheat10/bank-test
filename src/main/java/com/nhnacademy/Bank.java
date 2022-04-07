package com.nhnacademy;

import com.nhnacademy.exception.InvalidCurrencyException;

public class Bank {
    private final static double EXCHANGE_FEE = 0.05;


    public Money exchange(Money money, Currency currency) { // currency -> 환전이 될 통화
        // 1. money.getCurrency == currency -> throw Exception
        if (money.getCurrency()
                 .equals(currency)) {
            throw new InvalidCurrencyException();
        }

        double exchangedAmount;
        // 2. currency == WON
        if (currency.equals(Currency.WON)) {  // 다른 통화 -> 원으로 환전
            exchangedAmount = money.getCurrency().toWon(money.getAmount());
            return Money.WON((long) exchangedAmount);
        }

        // 3. money.getCurrency == WON
        if (money.getCurrency().equals(Currency.WON)) {  // 원 -> 다른 통화
            exchangedAmount = currency.fromWon((long) money.getAmount());
            return new Money(currency, exchangedAmount);
        }

        // 4. money.getCurrency != WON && currency != WON
        // TODO: 다른 통화 추가 시 작성

        return null;
    }

    public double getExchangedFee(Money money) {
        double amount = money.getAmount() * EXCHANGE_FEE;
//
        return amount;
    }


}
