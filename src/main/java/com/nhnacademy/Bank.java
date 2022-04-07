package com.nhnacademy;

import java.lang.reflect.Type;

public class Bank implements Exchangable {
    private final static double EXCHANGE_FEE = 0.05;


    private Money exchange(Money money,Currency currency){
        if (money.getAmount()
        money - getExchangedFee(money);
        return null;
    }

    @Override
    public double getExchangedFee(Money money) {
        double amount = money.getAmount() * EXCHANGE_FEE;

        return amount;
    }


}
