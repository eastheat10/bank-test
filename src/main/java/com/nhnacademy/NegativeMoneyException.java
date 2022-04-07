package com.nhnacademy;

public class NegativeMoneyException extends IllegalArgumentException {
    public NegativeMoneyException() {
        super("Money amount can't be negative");
    }
}
