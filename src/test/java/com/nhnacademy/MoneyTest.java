package com.nhnacademy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("화폐 비교")
    @Test
    void compareMoney() {
        Money money1 = new Money(Currency.WON, 10_000L);
        Money money2 = new Money(Currency.WON, 10_000L);

        assertThat(money1.equals(money2)).isTrue();
    }

    @DisplayName("화폐 더하기")
    @Test
    void plusMoney() {
        Money money1 = new Money(Currency.WON, 10_000L);
        Money money2 = new Money(Currency.WON, 10_000L);

        Money resultmoney = money1.add(money2);
        assertThat(money1.getAmount() + money2.getAmount()).isEqualTo(20_000);
    }

    @DisplayName("화폐 빼기")
    @Test
    void subtractMoney() {
        Money money1 = new Money(Currency.DOLLAR, 6);
        Money money2 = new Money(Currency.DOLLAR, 5);
        Money resultMoney = money1.subtract(money2);
        assertThat(money1.getAmount() - money2.getAmount()).isEqualTo(resultMoney.getAmount());
    }
}