package com.nhnacademy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {

    Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @DisplayName("수수료 확인")
    @Test
    void checkExchangeFee() {
        Money money1 = Money.WON(10_000L);

        assertThat(bank.getExchangedFee(money1.getAmount())).isEqualTo(money1.getAmount() * 0.05);
    }

    @DisplayName("[수수료 계산 포함] 환전 WON -> DOLLAR")
    @Test
    void exchangeToDollarFee() {

        Money moneyWon = Money.WON(10_000L);
        double exchangeResult = Money.DOLLAR(10)
                                     .getAmount() - bank.getExchangedFee(Money.DOLLAR(10)
                                                                              .getAmount());

        assertThat(bank.exchange(moneyWon, Currency.DOLLAR)
                       .getAmount()).isEqualTo(exchangeResult);
    }

    @DisplayName("[수수료 계산 포함] 환전 DOLLAR -> WON")
    @Test
    void exchangeToWonFee() {
        Money moneyDollar = Money.DOLLAR(10);
        double resultAmount = bank.exchange(moneyDollar, Currency.WON)
                                  .getAmount();
        long expectAmount = (long) (Money.WON(10_000L)
                                         .getAmount() - bank.getExchangedFee(10_000L));
        assertThat(resultAmount).isEqualTo(expectAmount);
    }

    @DisplayName("EURO -> DOLLAR 환전")
    @Test
    void euroToDollar() {
        Money euro = new Money(Currency.EURO, 100);
        // euro -> won 100 -> 130_000 - fee(6,500) = 123,500
        Money expect = Money.DOLLAR(123.5);

        Money exchangeResult = bank.exchange(euro, Currency.DOLLAR);

        assertThat(exchangeResult.getAmount()).isEqualTo(expect.getAmount());
    }
}