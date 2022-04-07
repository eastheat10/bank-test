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

    @DisplayName("수수료 확안")
    @Test
    void checkExchangeFee() {
        Money money1 = Money.WON(10_000L);

        assertThat(bank.getExchangedFee(money1)).isEqualTo(money1.getAmount() * 0.05);
    }

    @DisplayName("환전 WON -> DOLLAR")
    @Test
    void exchange() {
        Money money = Money.WON(10_000L); // 10$

        double exchangeResult = Money.DOLLAR(10).getAmount() - bank.getExchangedFee(Money.DOLLAR(10));

        assertThat(bank.exchange(money, Currency.DOLLAR)).isEqualTo(exchangeResult);


    }
}