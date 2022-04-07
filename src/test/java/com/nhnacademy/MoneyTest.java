package com.nhnacademy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("화폐 더하기 (WON)")
    @Test
    void plusMoney_WON() {
        Money money1 = new Money(Currency.WON, 10_000L);
        Money money2 = new Money(Currency.WON, 10_000L);

        Money resultmoney = money1.add(money2);
        assertThat(money1.getAmount() + money2.getAmount()).isEqualTo(20_000);
    }

    @DisplayName("화폐 더하기 (DOLLAR)")
    @Test
    void plusMoney_DOLLAR() {
        Money money1 = new Money(Currency.DOLLAR, 10);
        Money money2 = new Money(Currency.DOLLAR, 10);

        Money resultMoney = money1.add(money2);
        assertThat((money1.getAmount() + money2.getAmount())).isEqualTo(resultMoney.getAmount());

    }

    @DisplayName("화폐 빼기")
    @Test
    void subtractMoney() {
        Money money1 = new Money(Currency.DOLLAR, 6);
        Money money2 = new Money(Currency.DOLLAR, 5);
        Money resultMoney = money1.subtract(money2);
        assertThat(money1.getAmount() - money2.getAmount()).isEqualTo(resultMoney.getAmount());
    }

    @DisplayName("화폐를 뺸 결과가 음수 일때 (Dollar)")
    @Test
    void subtractMoneyIsMinus_DOLLAR() {
        Money money1 = new Money(Currency.DOLLAR, 5.0);
        Money money2 = new Money(Currency.DOLLAR, 6.0);
        assertThatThrownBy(() -> money1.subtract(money2))    //여기서 throw된 오류를 검증해서 맞으면 통과
                                                             .isInstanceOf(NegativeMoneyException.class)
                                                             .hasMessage("Money amount can't be negative");
    }

    @DisplayName("화폐를 뺸 결과가 음수 일때 (WON)")
    @Test
    void subtractMoneyIsMinus_WON() {
        Money money1 = new Money(Currency.WON, 10_000L);
        Money money2 = new Money(Currency.WON, 10_0000L);
        assertThatThrownBy(() -> money1.subtract(money2))    //여기서 throw된 오류를 검증해서 맞으면 통과
                                                             .isInstanceOf(NegativeMoneyException.class)
                                                             .hasMessage("Money amount can't be negative");
    }

    @DisplayName("달러 소수점 이하 2자리까지 반올림")
    @Test
    void dollarRound() {
        double amount = 5.016;  // 5.02 나와야 함
        double roundResult = Math.round(100 * amount) / 100.0;

        Money money = new Money(Currency.DOLLAR, amount);

        assertThat(money.getAmount()).isEqualTo(roundResult);
    }

    @DisplayName("원 1의 자리에서 반올림")
    @Test
    void wonRound() {
        long amount = 10_006L;  // 10_010 나와야 함
        double roundResult = Math.round(amount / 10.0) * 10;

        Money money = new Money(Currency.WON, amount);

        System.out.println("roundResult = " + roundResult);
        System.out.println("money = " + money.getAmount());
        assertThat(money.getAmount()).isEqualTo(roundResult);

    }

    @DisplayName("amount가 음수일 때")
    void negativeMoney() {
        long amount = -1;

        assertThatThrownBy(() -> new Money(Currency.WON, amount))
            .isInstanceOf(NegativeMoneyException.class);
    }

}