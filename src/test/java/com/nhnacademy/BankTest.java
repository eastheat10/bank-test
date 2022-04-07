package com.nhnacademy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {
    @DisplayName("수수료 확안")
    @Test
    void checkExchangeFee() {
        Bank bank = new Bank();
        Money money1 = new Money(Currency.WON, 10_000L);

        assertThat(bank.getExchangedFee(money1)).isEqualTo(money1.getAmount() * 0.05);
    }
}