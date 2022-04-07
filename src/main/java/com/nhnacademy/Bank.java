package com.nhnacademy;

public class Bank implements Exchangable {
    private final static double EXCHANGE_FEE = 0.05;


    public Money exchange(Money money, Currency currency) {
//        money - getExchangedFee(money);

        return null;
    }

    @Override
    public double getExchangedFee(Money money) {
        double amount = money.getAmount() * EXCHANGE_FEE;

        return amount;
    }


}
